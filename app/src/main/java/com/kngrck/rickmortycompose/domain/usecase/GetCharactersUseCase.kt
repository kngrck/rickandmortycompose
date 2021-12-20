package com.kngrck.rickmortycompose.domain.usecase

import com.kngrck.rickmortycompose.domain.model.Characters
import com.kngrck.rickmortycompose.domain.repository.RickMortyRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    suspend operator fun invoke(pageNumber: Int): Characters {
        return repository.getCharacters(pageNumber)
    }
}