package com.erik.gameshop.di

import com.erik.gameshop.network.model.GameDtoMapper
import com.erik.gameshop.network.services.GameService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGameMapper(): GameDtoMapper{
        return GameDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGameService(): GameService{
        return Retrofit.Builder()
                .baseUrl("https://api.rawg.io/api/")
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
                 .create(GameService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "9866b8ab2ffb4e5495cb366b3ae6cae4"
    }
}

//        val service = Retrofit.Builder()
//            .baseUrl("https://api.rawg.io/api/")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//            .create(GameService::class.java)
//
//        CoroutineScope(IO).launch {
//
//            try {
//                val response = service.getAllGames(
//                    token = "9866b8ab2ffb4e5495cb366b3ae6cae4",
//                    page = 1
//                )
//
//                Log.d("MainActivity", "onCreate1: ${response.count}")
//            }
//            catch (e : Exception){
//                Log.d("MainActivity", "onError: ${e}")
//            }
//
//
//
//        }