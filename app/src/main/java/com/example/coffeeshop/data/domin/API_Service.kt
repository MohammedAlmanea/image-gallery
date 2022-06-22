package com.example.coffeeshop.data.domin

import retrofit2.http.GET

interface API_Service {
    @GET("v2/list")
    suspend fun getImages():List<Image>
}