package com.willychuang.access

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background))
            .into(imgView)
    }
}

@BindingAdapter("isAdmin")
fun isAdmin(textView: TextView, isAdmin: Boolean) {
    if(isAdmin) {
        textView.text = "Admin"
    } else {
        textView.text = "Staff"
    }
}