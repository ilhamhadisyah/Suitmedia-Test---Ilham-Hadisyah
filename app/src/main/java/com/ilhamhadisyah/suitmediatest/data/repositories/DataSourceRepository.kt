package com.ilhamhadisyah.suitmediatest.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel

interface DataSourceRepository {

    fun getGuests(page: Int): LiveData<Resources<PagedList<GuestModel>>>
}