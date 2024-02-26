package com.example.practicacleanarhitecture.domain.repository

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthRespository {

    @GET("products")
    suspend fun getListProduct(): Call<ResponseBody>
}