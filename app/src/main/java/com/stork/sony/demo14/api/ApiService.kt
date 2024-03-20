package com.stork.sony.demo14.api

import com.stork.sony.demo14.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api")
    fun getUsers(): Call<UserResponse>
}