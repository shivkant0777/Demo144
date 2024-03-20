package com.stork.sony.demo14.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.stork.sony.demo14.databinding.UserItemBinding
import com.stork.sony.demo14.model.Result



class UserAdapter(private val items: List<Result>?) : androidx.recyclerview.widget.RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    lateinit var listener: OnUserClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items!!.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items!![position])

    inner class ViewHolder(private val binding: UserItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.apply {
                viewModel = item

                executePendingBindings()

                container.setOnClickListener {
                    listener.onUserClick(it,item)
                }
            }
        }
    }

    interface OnUserClickListener {

        fun onUserClick(view: View, result: Result)

    }

    fun setOnItemClickListener(listener: OnUserClickListener) {
        this.listener = listener
    }


}