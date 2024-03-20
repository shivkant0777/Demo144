package com.stork.sony.demo14.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stork.sony.demo14.model.Result

class UserDetailViewModel : ViewModel() {

    val result = MutableLiveData<Result>()
}