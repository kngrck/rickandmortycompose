package com.kngrck.rickmortycompose.domain.repository

import com.kngrck.rickmortycompose.domain.model.CharacterDetail
import com.kngrck.rickmortycompose.domain.model.Characters

interface RickMortyRepository {

    suspend fun getCharacters(pageNumber: Int): Characters

    suspend fun getCharacterById(characterId: Int): CharacterDetail
}