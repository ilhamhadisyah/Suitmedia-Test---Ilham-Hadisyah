package com.ilhamhadisyah.suitmediatest.data.datasource.local.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel

@Database(entities = [GuestModel::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun databaseObject(): DatabaseObject
}