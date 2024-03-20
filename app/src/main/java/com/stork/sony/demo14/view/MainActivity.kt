package com.stork.sony.demo14.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.stork.sony.demo14.R
import com.stork.sony.demo14.adapter.UserAdapter
import com.stork.sony.demo14.databinding.ActivityMainBinding
import com.stork.sony.demo14.model.Result
import com.stork.sony.demo14.utils.RESULT_KEY
import com.stork.sony.demo14.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), UserAdapter.OnUserClickListener {

    private val mainViewModel: MainViewModel by viewModels()
    private  lateinit var userAdapter: UserAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
           .apply {
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }

        initObserver()
        mainViewModel.getUserResponse()
    }

    private fun initObserver() {
        mainViewModel.userResponse.observe(this, Observer {
            if (it != null) {
                setUserAdapter(it.results)
            }

        })
    }

    private fun setUserAdapter(userList: List<Result>) {

        userAdapter = UserAdapter(  userList)
        userAdapter.setOnItemClickListener(this)
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                this@MainActivity,
                androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    private fun detailActivity(result: Result) {
        val intent = Intent(this, UserDetailActivity::class.java)
        intent.putExtra(RESULT_KEY,  Gson().toJson(result))
        startActivity(intent)
    }

    override fun onUserClick(view: View, result: Result) {
        detailActivity(result)
    }

}