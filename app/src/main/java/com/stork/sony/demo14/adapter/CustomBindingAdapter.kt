package com.stork.sony.demo14.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stork.sony.demo14.R

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .fitCenter()
            .into(view)
    }
}