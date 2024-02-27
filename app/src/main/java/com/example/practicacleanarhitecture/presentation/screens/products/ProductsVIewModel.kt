package com.example.practicacleanarhitecture.presentation.screens.products

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicacleanarhitecture.domain.model.Products
import com.example.practicacleanarhitecture.domain.model.Respons
import com.example.practicacleanarhitecture.domain.use_cases.products.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsVIewModel @Inject constructor(private val productsUseCase: ProductsUseCase) : ViewModel(){

    var postsRespons by mutableStateOf<Respons<List<Products>>?>(null)
    init {
        getPosts()
    }

    private fun getPosts() = viewModelScope.launch {
        //postsRespons = Respons.Loading
       val data = productsUseCase.getProducts()
        Log.e("TAG", "getPosts $data")
    }

}