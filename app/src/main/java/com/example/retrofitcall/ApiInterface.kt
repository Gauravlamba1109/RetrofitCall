package com.example.retrofitcall

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL ="https://api.publicapis.org/"

interface ApiInterface {

    @GET("entries")
    fun getData():Call<Outerdata>
}
