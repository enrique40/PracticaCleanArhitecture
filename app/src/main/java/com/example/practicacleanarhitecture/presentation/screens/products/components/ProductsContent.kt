package com.example.practicacleanarhitecture.presentation.screens.products.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicacleanarhitecture.domain.model.Products

@Composable
fun ProductsContent(
    post: List<Products>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 80.dp)
    ) {
        items(
            items = post
        ) { post->
            Log.e("TAG", "ProductsContent $post")
          //  PostsCard(navController =  navController, post = post)
        }
    }
}