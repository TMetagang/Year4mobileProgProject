package com.example.year4mobileprogproject.data.local.api

import retrofit2.http.GET

interface ApiService{

    @GET("/API/MostPopularTVs/k_8rZ9Ie4z")

    suspend fun getUser(

    )
}