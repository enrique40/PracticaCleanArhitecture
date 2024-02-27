package com.example.practicacleanarhitecture.presentation.screens.products.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.practicacleanarhitecture.domain.model.Respons
import com.example.practicacleanarhitecture.presentation.component.ProgressBar
import com.example.practicacleanarhitecture.presentation.screens.products.ProductsVIewModel

@Composable
fun GetProducts(viewModel: ProductsVIewModel = hiltViewModel()) {
    when (val response = viewModel.postsRespons) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Respons.Loading -> {
            ProgressBar()
        }
        is Respons.Success -> {
            ProductsContent(post = response.data)
        }
        is Respons.Failure -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconido",
                Toast.LENGTH_LONG
            ).show()
        }
        else -> {}
    }
}