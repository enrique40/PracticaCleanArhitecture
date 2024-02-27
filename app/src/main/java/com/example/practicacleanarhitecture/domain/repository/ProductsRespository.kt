package com.example.practicacleanarhitecture.domain.repository

import com.example.practicacleanarhitecture.domain.model.Respons
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ProductsRespository {

    @GET("products")
    suspend fun getListProduct(): Response<ResponseBody>
}