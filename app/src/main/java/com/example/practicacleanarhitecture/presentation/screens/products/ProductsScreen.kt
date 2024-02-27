package com.example.practicacleanarhitecture.presentation.screens.products

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.practicacleanarhitecture.presentation.screens.products.components.GetProducts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductsScreen() {
    Scaffold(
        content = {
            GetProducts()
        }
    )


}