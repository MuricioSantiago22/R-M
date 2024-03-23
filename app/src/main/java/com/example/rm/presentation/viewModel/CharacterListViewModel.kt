package com.example.rm.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rm.domain.entities.Character
import com.example.rm.domain.paged.CharacterListSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel@Inject constructor(
    private val characterListSource: CharacterListSource
):ViewModel() {

    val characters : Flow<PagingData<Character>> =
        Pager(PagingConfig(pageSize = 20)){
            characterListSource
        }.flow

}