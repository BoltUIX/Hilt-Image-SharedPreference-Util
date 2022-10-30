package com.boltuix.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.boltuix.mvvm.model.repository.MyImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FirstFragmentViewModel  @Inject constructor(
    private val repository: MyImageRepository
): ViewModel(){

    private val _imageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = _imageUrlLiveData

    fun fetchNewImageUrl() {
        val newImageUrl = repository.getRandomImageUrl()
        _imageUrlLiveData.value =newImageUrl
    }


}