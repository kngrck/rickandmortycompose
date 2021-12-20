package com.kngrck.rickmortycompose.domain.usecase

import com.kngrck.rickmortycompose.domain.model.CharacterDetail
import com.kngrck.rickmortycompose.domain.repository.RickMortyRepository
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    suspend operator fun invoke(characterId: Int): CharacterDetail {
        return repository.getCharacterById(characterId)
    }
}