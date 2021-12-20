package com.kngrck.rickmortycompose.presentation.ui.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kngrck.rickmortycompose.domain.model.CharacterDetail
import com.kngrck.rickmortycompose.presentation.ui.Screen
import com.kngrck.rickmortycompose.presentation.ui.characters.components.CharacterListItem
import retrofit2.http.Header

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val characters: LazyPagingItems<CharacterDetail> =
        viewModel.characters.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(characters) { character ->
                character?.let {
                    CharacterListItem(
                        character = character,
                        onItemClick = {
                            navController.navigate(Screen.CharacterDetailScreen.route + "/${character.id}")
                        }
                    )
                    Divider()
                }
            }
        }
    }
}