package com.ilhamhadisyah.suitmediatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import com.ilhamhadisyah.suitmediatest.data.repositories.DataRepositories
import com.ilhamhadisyah.suitmediatest.data.repositories.Resources
import javax.inject.Inject

class GuestViewModel @Inject constructor(private var dataRepositories: DataRepositories) :
    ViewModel() {

//    fun getGuest(page: Int): LiveData<Resources<PagedList<GuestModel>>> =
//        dataRepositories.getGuests(page)
    val initialLoading = MutableLiveData<Resources<PagedList<GuestModel>>>()
    val networkState = MutableLiveData<Resources<PagedList<GuestModel>>>()

    fun getGuest(page: Int): LiveData<Resources<PagedList<GuestModel>>> =
        dataRepositories.getGuests(page)

    fun observePage(): PageKeyedDataSource<Long, GuestModel> {
        return object : PageKeyedDataSource<Long,GuestModel>(){
            override fun loadAfter(
                params: LoadParams<Long>,
                callback: LoadCallback<Long, GuestModel>
            ) {
                TODO("Not yet implemented")
            }

            override fun loadBefore(
                params: LoadParams<Long>,
                callback: LoadCallback<Long, GuestModel>
            ) {
                TODO("Not yet implemented")
            }

            override fun loadInitial(
                params: LoadInitialParams<Long>,
                callback: LoadInitialCallback<Long, GuestModel>
            ) {
                TODO("Not yet implemented")
            }

        }
    }
}