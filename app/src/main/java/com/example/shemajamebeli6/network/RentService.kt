package com.example.shemajamebeli6.network

import com.example.shemajamebeli6.model.Content
import retrofit2.Response
import retrofit2.http.GET

interface RentService {

    @GET("v3/f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun getAnnouncements(): Response<Content>

}