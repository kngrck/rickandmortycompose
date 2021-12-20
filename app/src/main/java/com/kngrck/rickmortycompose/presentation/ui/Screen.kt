package com.kngrck.rickmortycompose.presentation.ui

sealed class Screen(val route: String) {
    object CharactersScreen : Screen("characters_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")
}



