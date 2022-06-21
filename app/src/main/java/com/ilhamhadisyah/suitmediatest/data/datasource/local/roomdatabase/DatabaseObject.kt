package com.ilhamhadisyah.suitmediatest.data.datasource.local.roomdatabase

import androidx.paging.DataSource
import androidx.room.*
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel


@Dao
interface DatabaseObject {
    @Query("SELECT * FROM guest")
    fun getGuestList(): DataSource.Factory<Int, GuestModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGuest(guest: List<GuestModel>): LongArray

    @Update
    fun updateGuest(guest: GuestModel): Int
}