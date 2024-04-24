package com.example.rm.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rm.domain.entities.Character
import com.example.rm.domain.paged.CharacterListSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel@Inject constructor(
    private val characterListSource: CharacterListSource
):ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    private val searchQuery: StateFlow<String> = _searchQuery

    val characters : Flow<PagingData<Character>> =
        searchQuery.flatMapLatest { query ->
            Pager(PagingConfig(pageSize = 20)){
                characterListSource
            }.flow.flowOn(Dispatchers.IO)
        }

    fun setQuery(query:String){
        _searchQuery.value = query
        characterListSource.setQuery(query)

    }
}