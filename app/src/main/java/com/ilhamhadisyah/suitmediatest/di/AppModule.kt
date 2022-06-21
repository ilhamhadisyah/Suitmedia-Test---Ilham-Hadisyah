package com.ilhamhadisyah.suitmediatest.di

import android.content.Context
import androidx.room.Room
import com.ilhamhadisyah.suitmediatest.BuildConfig
import com.ilhamhadisyah.suitmediatest.data.datasource.local.roomdatabase.Database
import com.ilhamhadisyah.suitmediatest.data.datasource.local.roomdatabase.DatabaseObject
import com.ilhamhadisyah.suitmediatest.data.datasource.remote.retrofit.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): Database = Room.databaseBuilder(
        context, Database::class.java, "suitmedia.db"
    ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideDao(database: Database): DatabaseObject = database.databaseObject()

    @Singleton
    @Provides
    fun provideRetrofitService() : ApiService =  Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(ApiService::class.java)
}