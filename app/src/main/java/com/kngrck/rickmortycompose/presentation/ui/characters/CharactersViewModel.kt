package com.kngrck.rickmortycompose.presentation.ui.characters

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kngrck.rickmortycompose.domain.CharactersPagingSource
import com.kngrck.rickmortycompose.domain.model.CharacterDetail
import com.kngrck.rickmortycompose.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val characters = Pager(PagingConfig(pageSize = 20)) {
        CharactersPagingSource(getCharactersUseCase)
    }.flow

}