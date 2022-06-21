package com.ilhamhadisyah.suitmediatest.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ilhamhadisyah.suitmediatest.data.datasource.local.LocalRepository
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.ApiResponse
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.RemoteRepository
import com.ilhamhadisyah.suitmediatest.data.model.EventDummy
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import com.ilhamhadisyah.suitmediatest.utils.AppExecutor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepositories @Inject constructor(
    private var localRepository: LocalRepository,
    private var remoteRepository: RemoteRepository,
    private var appExecutor: AppExecutor
) : DataSourceRepository {
    override fun getGuests(page: Int): LiveData<Resources<PagedList<GuestModel>>> {
        return object : NetworkBoundResource<PagedList<GuestModel>, List<GuestModel>>(appExecutor) {
            override fun loadFromDB(): LiveData<PagedList<GuestModel>> {
                return LivePagedListBuilder(localRepository.getGuestAsPaged(), 10).build()
            }

            override fun shouldFetch(data: PagedList<GuestModel>?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<List<GuestModel>>>? {
                return remoteRepository.getGuests(page)
            }

            override fun saveCallResult(data: List<GuestModel>) {
                localRepository.insertGuests(data)
            }

        }.asLiveData()
    }

    fun getEventsAsLiveData(): LiveData<List<EventModel>> {
        val eventData = MutableLiveData<List<EventModel>>()
        eventData.postValue(EventDummy.getEventData())
        return eventData
    }
}