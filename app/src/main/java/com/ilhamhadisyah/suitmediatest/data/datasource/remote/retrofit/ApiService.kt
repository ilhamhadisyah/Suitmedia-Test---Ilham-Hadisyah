package com.ilhamhadisyah.suitmediatest.data.datasource.remote.retrofit

import com.ilhamhadisyah.suitmediatest.data.model.Response
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getGuestAsync(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Deferred<Response>
}