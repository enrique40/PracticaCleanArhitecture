package com.example.practicacleanarhitecture.di

import com.example.practicacleanarhitecture.data.repository.ProductsRepositoryImpl
import com.example.practicacleanarhitecture.domain.repository.ProductsRespository
import com.example.practicacleanarhitecture.domain.use_cases.products.GetProducts
import com.example.practicacleanarhitecture.domain.use_cases.products.ProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer 19a859b393c8d35bebafbb5d9dc8933739ef5f0e6d88ee3a91361f523a73f3298f8e226911a65fd08ecef3c25fff99023c13a5bc2abf9ce28f753109bc24cceb14d72926fb8c18615080bf3b5452fe124cfb0727fbd343d72802700f2072d80aeada26dfd70e6f8bcaff3a3c204cd043e2335f173294021a7844de39d59bae3a")
                .build()
            chain.proceed(newRequest)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:1337")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ProductsRespository {
        return retrofit.create(ProductsRespository::class.java)
    }

/*    @Provides
    fun providerPostRepository(impl: ProductsRepositoryImpl): ProductsRespository = impl*/

    @Provides
    fun provideProductsUseCase(respository: ProductsRespository) = ProductsUseCase(
        getProducts = GetProducts(respository)
    )
}