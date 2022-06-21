package com.ilhamhadisyah.suitmediatest.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.ApiResponse
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.StatusResponse
import com.ilhamhadisyah.suitmediatest.utils.AppExecutor

abstract class NetworkBoundResource<ResultType, RequestType>(private val appExecutor: AppExecutor) {
    private val resultSet = MediatorLiveData<Resources<ResultType>>()

    init {
        resultSet.value = Resources.Loading(null)
        val dbSource = loadFromDB()
        resultSet.addSource(dbSource) { data ->
            resultSet.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                resultSet.addSource(dbSource) {
                    resultSet.value = Resources.Success(it)
                }
            }
        }
    }

    private fun onFetchFailed() {}
    protected abstract fun loadFromDB(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>?
    protected abstract fun saveCallResult(data: RequestType)
    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall() as LiveData<ApiResponse<RequestType>>
        resultSet.addSource(dbSource) { newData -> resultSet.value = Resources.Loading(newData) }
        resultSet.addSource(apiResponse) { response ->
            resultSet.removeSource(apiResponse)
            resultSet.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS -> appExecutor.diskIO().execute {
                    saveCallResult(response.body)
                    appExecutor.mainThread().execute {
                        resultSet.addSource(loadFromDB()) {
                            resultSet.value = Resources.Success(it)
                        }
                    }
                }
                StatusResponse.EMPTY -> appExecutor.mainThread().execute {
                    resultSet.addSource(loadFromDB()) {
                        resultSet.value = Resources.Success(it)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    resultSet.addSource(dbSource) {
                        resultSet.value = Resources.Error(it, response.message.toString())
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resources<ResultType>> {
        return resultSet
    }
}