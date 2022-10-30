package com.boltuix.mvvm.model.di

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PicassoModule {
    // @InstallIn(SingletonComponent.class) module providers have access to the Application binding.
    @Provides
    fun providesPicasso(): Picasso {
        return Picasso.get()
    }
}



