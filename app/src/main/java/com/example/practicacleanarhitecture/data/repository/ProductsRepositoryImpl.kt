package com.example.practicacleanarhitecture.data.repository

import android.util.Log
import com.example.practicacleanarhitecture.domain.model.Respons
import com.example.practicacleanarhitecture.domain.repository.ProductsRespository
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val repository: ProductsRespository) : ProductsRespository  {
    override suspend fun getListProduct(): Response<ResponseBody> {
        Log.e("TAG", "getListProduct: ")
        return try {
            Log.e("TAG", "getListProduct1 ")
            val result = repository.getListProduct()
            if (result.isSuccessful){
                Log.e("TAG", "getListProduct $result " )
                Response.success(result.body()!!)
            } else {
                Response.error(result.code(), result.errorBody()!!)
            }
        } catch (e: Exception) {
            val errorBody = ResponseBody.create("text/plain".toMediaTypeOrNull(), e.message ?: "Unknown error")
            Response.error(500, errorBody)
        }
    }

}