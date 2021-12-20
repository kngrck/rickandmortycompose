package com.kngrck.rickmortycompose.presentation.ui.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kngrck.rickmortycompose.common.Constants
import com.kngrck.rickmortycompose.domain.usecase.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getCharacter(characterId)
        }
    }

    private fun getCharacter(characterId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            try {
                val result = getCharacterDetailUseCase(characterId.toInt())
                _state.value = state.value.copy(character = result)
            } catch (e: HttpException) {
                _state.value = state.value.copy(error = e.message())
            } catch (e: Exception) {
                _state.value = state.value.copy(error = e.message ?: "Unknown error!")
            } finally {
                _state.value = state.value.copy(isLoading = false)
            }

        }

    }
}