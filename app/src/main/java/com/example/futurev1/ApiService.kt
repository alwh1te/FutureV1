package com.example.futurev1

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/semi-final-data.json/")

    fun getPosts() : Call<MutableList<Item>>

}