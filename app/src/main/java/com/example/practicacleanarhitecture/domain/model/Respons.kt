package com.example.practicacleanarhitecture.domain.model

sealed class Respons<out T> {
    object Loading: Respons<Nothing>()
    data class Success<out T>(val data: T): Respons<T>()
    data class Failure<out T>(val exception: Exception?): Respons<T>()
}