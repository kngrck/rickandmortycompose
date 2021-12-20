package com.kngrck.rickmortycompose.di

import com.kngrck.rickmortycompose.common.Constants
import com.kngrck.rickmortycompose.data.remote.RickMortyApi
import com.kngrck.rickmortycompose.data.remote.repository.RickMortyRepositoryImpl
import com.kngrck.rickmortycompose.domain.repository.RickMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickMortyApi(): RickMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickMortyRepository(api: RickMortyApi): RickMortyRepository {
        return RickMortyRepositoryImpl(api)
    }
}