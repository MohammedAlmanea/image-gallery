package com.example.coffeeshop.data.repository

import com.example.coffeeshop.common.Response
import com.example.coffeeshop.data.domin.API_Service
import com.example.coffeeshop.data.domin.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val api_service : API_Service
) {
    suspend fun getImages(): List<Image>{
        return api_service.getImages()
    }
    fun getAllImages():Flow<Response<List<Image>>> = flow {
        try {
            emit(Response.Loading<List<Image>>())
            val image = getImages()
            emit(Response.Success<List<Image>>(image))

        } catch (e:HttpException){
            emit(Response.Error<List<Image>>(e.localizedMessage ?: "There is something wrong"))
        }
        catch (e: IOException)
        {
            emit(Response.Error<List<Image>>("Failed ot connect to server\n┗( T﹏T )┛"))
        }

    }
}