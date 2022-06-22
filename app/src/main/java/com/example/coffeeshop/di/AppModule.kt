package com.example.coffeeshop.di

import com.example.coffeeshop.common.Constants
import com.example.coffeeshop.data.domin.API_Service
import com.example.coffeeshop.data.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAPIService(): API_Service {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API_Service::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: API_Service): ImageRepository {
        return ImageRepository(api_service = api)
    }
}