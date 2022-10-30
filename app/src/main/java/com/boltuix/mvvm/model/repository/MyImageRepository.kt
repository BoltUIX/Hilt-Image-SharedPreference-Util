package com.boltuix.mvvm.model.repository

import com.boltuix.mvvm.model.api.MyImageUrlService
import javax.inject.Inject


class MyImageRepository @Inject constructor(
    private val service: MyImageUrlService) {
    fun getRandomImageUrl(): String {
        return service.getImageUrl()
    }
}