package com.kngrck.rickmortycompose.domain.model

data class Characters(
    val nextPage: String?,
    val characters: List<CharacterDetail>
)
