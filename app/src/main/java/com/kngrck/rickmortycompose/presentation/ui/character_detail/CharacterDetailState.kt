package com.kngrck.rickmortycompose.presentation.ui.character_detail

import com.kngrck.rickmortycompose.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = ""
)