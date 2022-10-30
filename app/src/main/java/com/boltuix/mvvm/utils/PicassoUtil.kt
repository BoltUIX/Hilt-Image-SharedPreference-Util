package com.boltuix.mvvm.utils

import android.content.SharedPreferences
import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PicassoUtil @Inject constructor(private val picasso: Picasso) {

    fun loadImage(imageUrl: String, imageView: ImageView) {
        picasso.load(imageUrl).into(imageView)
    }
}

