package com.ilhamhadisyah.suitmediatest.data.datasource.local

import androidx.paging.DataSource
import com.ilhamhadisyah.suitmediatest.data.datasource.local.roomdatabase.DatabaseObject
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepository @Inject constructor(private val database : DatabaseObject) {

    fun getGuestAsPaged():DataSource.Factory<Int,GuestModel> =database.getGuestList()

    fun insertGuests(guests : List<GuestModel>){
        database.insertGuest(guests)
    }

}