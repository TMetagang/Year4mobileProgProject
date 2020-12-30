package com.example.year4mobileprogproject.data.local.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder{

    const val BASE_URL = "https://imdb-api.com/API/MostPopularTVs/k_8rZ9Ie4z"

    val retrofitBuilder: Retrofit.Builder by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: ApiService by lazy{

        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }

}