package com.erik.gameshop.di

import com.erik.gameshop.network.model.GameDtoMapper
import com.erik.gameshop.network.services.GameService
import com.erik.gameshop.repository.GameRepository
import com.erik.gameshop.repository.GameRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGameRepository(
        gameService: GameService,
        gameDtoMapper: GameDtoMapper
    ): GameRepository{
        return GameRepositoryImplementation(gameService, gameDtoMapper)
    }
}