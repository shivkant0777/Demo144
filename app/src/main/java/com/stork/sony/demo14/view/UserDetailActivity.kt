package com.stork.sony.demo14.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.stork.sony.demo14.R
import com.stork.sony.demo14.databinding.ActivityUserDetailBinding
import com.stork.sony.demo14.model.Result
import com.stork.sony.demo14.utils.RESULT_KEY
import com.stork.sony.demo14.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity() {

    private val userDetailViewModel: UserDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       DataBindingUtil.setContentView<ActivityUserDetailBinding>(this, R.layout.activity_user_detail)
           .apply {
            viewModel = userDetailViewModel
            lifecycleOwner = this@UserDetailActivity
        }
        getData()
    }

    private fun getData() {
        val data = intent.getStringExtra(RESULT_KEY)
        val user = Gson().fromJson(data, Result::class.java)
        userDetailViewModel.result.value = user
        println(user.email)
    }
}