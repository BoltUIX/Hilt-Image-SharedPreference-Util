package com.boltuix.mvvm.model.api

import javax.inject.Inject

class MyImageUrlService @Inject constructor() {

    private val imageUrls = listOf(
        "https://i.pinimg.com/564x/25/e6/83/25e683b3d081ad739f437a90ff0c7f75.jpg",
        "https://i.pinimg.com/564x/62/d6/06/62d6067b56683c010dac81b99a8f6ca1.jpg",
        "https://i.pinimg.com/564x/f4/62/c6/f462c65094e2f57a67088f28a3776390.jpg",
    )

    fun getImageUrl(): String {
        return imageUrls.random()
    }
}