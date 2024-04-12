package com.example.rm.presentation.ui.screen.characterListView

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.rm.domain.entities.Character
import com.example.rm.presentation.ui.screen.stateView.ErrorItem
import com.example.rm.presentation.ui.screen.stateView.LoadingItem
import com.example.rm.presentation.ui.screen.stateView.LoadingView
import com.example.rm.presentation.viewModel.CharacterListViewModel
import com.example.rm.presentation.viewModel.SharedViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,

){
    val viewModel: CharacterListViewModel = hiltViewModel()
    val topAppBarTextStyle = MaterialTheme.typography.headlineSmall
        .copy(fontWeight = FontWeight.Bold)
    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Characters",
                        textAlign = TextAlign.Center,
                        style = topAppBarTextStyle,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )}
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            SearchBarCharacters(
                viewModel = viewModel
            )
            CharacterList(
                characters = viewModel.characters,
                modifier = Modifier.fillMaxWidth(),
                navController,
                sharedViewModel,
                listState
            )

        }
    }
}

@Composable
fun CharacterList(
    characters: Flow<PagingData<Character>>,
    modifier: Modifier = Modifier,
    navController: NavController,
    sharedViewModel: SharedViewModel,
    listState: LazyListState = rememberLazyListState()
) {
    val lazyProductItems = characters.collectAsLazyPagingItems()
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn( state = listState ) {
            items(lazyProductItems) { character ->
                ProductItem(
                    sharedViewModel = sharedViewModel,
                    navController,
                    character!!
                )
            }
        }
        when {
            lazyProductItems.loadState.refresh is LoadState.Loading -> {
                LoadingView(
                    modifier = Modifier.fillMaxSize()
                )
            }
            lazyProductItems.loadState.append is LoadState.Loading -> {
                LoadingItem()
            }
            lazyProductItems.loadState.refresh is LoadState.Error -> {
                val e = lazyProductItems.loadState.refresh as LoadState.Error
                ErrorItem(
                    message = e.error.localizedMessage ?: "",
                    modifier = Modifier.fillMaxSize(),
                    onClickRetry = { lazyProductItems.retry() }
                )
            }
            lazyProductItems.loadState.append is LoadState.Error -> {
                val e = lazyProductItems.loadState.append as LoadState.Error
                ErrorItem(
                    message = e.error.localizedMessage ?: "",
                    modifier = Modifier.fillMaxSize(),
                    onClickRetry = { lazyProductItems.retry() }
                )
            }
        }
        AnimatedVisibility(
            visible = !listState.isScrollingUp(),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            GoToTop {
                coroutineScope.launch {
                    listState.scrollToItem(0)
                }
            }
        }
    }
}