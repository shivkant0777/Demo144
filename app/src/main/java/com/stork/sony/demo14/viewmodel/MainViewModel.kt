package com.stork.sony.demo14.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.stork.sony.demo14.api.ApiConfig
import com.stork.sony.demo14.model.UserResponse
import retrofit2.Call
import retrofit2.Callback

class MainViewModel: ViewModel() {

    val userResponse = MutableLiveData<UserResponse>()
    val isLoading = MutableLiveData<Boolean>(true)

    fun getUserResponse() {
        val client = ApiConfig.getApiService().getUsers()
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: retrofit2.Response<UserResponse>) {
                val responseBody = response.body()

                if (!response.isSuccessful || responseBody == null) {

                }
                userResponse.value = responseBody
                isLoading.value = false
                println(userResponse.value?.info?.seed)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                onError(t.message)
            }

        })
    }

    private  fun onError(msg: String?) {
        val message = if (msg.isNullOrBlank() or msg.isNullOrEmpty()) "Unknown Error" else msg
    }
}