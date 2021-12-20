package com.kngrck.rickmortycompose.data.remote.repository

import com.kngrck.rickmortycompose.data.remote.RickMortyApi
import com.kngrck.rickmortycompose.data.remote.dto.toCharacterDetail
import com.kngrck.rickmortycompose.data.remote.dto.toCharacters
import com.kngrck.rickmortycompose.domain.model.CharacterDetail
import com.kngrck.rickmortycompose.domain.model.Characters
import com.kngrck.rickmortycompose.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
) : RickMortyRepository {

    override suspend fun getCharacters(pageNumber: Int): Characters {
        val characters = api.getCharacters(pageNumber)
        return characters.toCharacters()
    }


    override suspend fun getCharacterById(characterId: Int): CharacterDetail {
        val character = api.getCharacterById(characterId)
        return character.toCharacterDetail()
    }
}