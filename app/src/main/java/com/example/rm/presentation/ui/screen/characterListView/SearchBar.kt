@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.rm.presentation.ui.screen.characterListView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.rm.presentation.viewModel.CharacterListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarCharacters(
    viewModel:CharacterListViewModel
    ){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    )
    {
        var query by remember{ mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        SearchBar(
            query = query,
            onQueryChange = {
                query =it
            },
            onSearch ={
                viewModel.setQuery(query)
                query= ""
                active
            },
            active = active ,
            onActiveChange ={
                active= !it
            },
            modifier= Modifier.wrapContentHeight(),
            placeholder = {
                Text(
                    text = "Search by name"
                )
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                        viewModel.setQuery(query)
                        query =""
                    },
                    enabled = true
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        ) {
        }
    }

}