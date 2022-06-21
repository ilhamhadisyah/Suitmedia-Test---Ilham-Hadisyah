package com.ilhamhadisyah.suitmediatest.data.datasource.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.retrofit.ApiService
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(private val apiService: ApiService) {

    fun getGuests(page: Int): LiveData<ApiResponse<List<GuestModel>>> {
        val result = MutableLiveData<ApiResponse<List<GuestModel>>>()
        GlobalScope.launch {
            val postRequest = apiService.getGuestAsync(page, 10)
            val postResponse = postRequest.await().data
            result.postValue(ApiResponse.success(postResponse as List<GuestModel>))
        }
        return result
    }
}