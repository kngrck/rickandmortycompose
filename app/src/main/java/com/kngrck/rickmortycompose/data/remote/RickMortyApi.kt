package com.kngrck.rickmortycompose.data.remote

import com.kngrck.rickmortycompose.data.remote.dto.CharacterDto
import com.kngrck.rickmortycompose.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") pageNumber: Int): CharactersDto

    @GET("character/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): CharacterDto
}