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


    fun getGuest(page: Int): LiveData<Resources<PagedList<GuestModel>>> =
        dataRepositories.getGuests(page)


}