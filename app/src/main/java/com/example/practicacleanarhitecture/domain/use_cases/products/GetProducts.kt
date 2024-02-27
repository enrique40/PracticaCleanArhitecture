package com.example.practicacleanarhitecture.domain.use_cases.products
import com.example.practicacleanarhitecture.domain.repository.ProductsRespository
import javax.inject.Inject

class GetProducts @Inject constructor(private val productsRespository: ProductsRespository) {
     suspend operator fun invoke() = productsRespository.getListProduct()
}