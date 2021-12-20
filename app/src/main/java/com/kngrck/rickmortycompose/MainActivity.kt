package com.kngrck.rickmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kngrck.rickmortycompose.presentation.ui.Screen
import com.kngrck.rickmortycompose.presentation.ui.character_detail.CharacterDetailScreen
import com.kngrck.rickmortycompose.presentation.ui.characters.CharactersScreen
import com.kngrck.rickmortycompose.presentation.ui.theme.RickMortyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharactersScreen.route
                    ) {
                        composable(
                            route = Screen.CharactersScreen.route
                        ) {
                            CharactersScreen(navController)
                        }
                        composable(
                            route = Screen.CharacterDetailScreen.route + "/{characterId}"
                        ) {
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
