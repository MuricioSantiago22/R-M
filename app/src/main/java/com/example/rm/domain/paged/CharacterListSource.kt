package com.example.rm.domain.paged
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rm.domain.entities.Character
import com.example.rm.domain.repository.CharacterListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterListSource@Inject constructor(
    private val characterListRepository: CharacterListRepository
): PagingSource<Int, Character>() {

    private var currentQuery: String? = null

    fun setQuery(query: String) {
        currentQuery = query
    }
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return null
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return withContext(Dispatchers.IO) { try{
            val pageNumber = params.key ?: 1
            val response = characterListRepository.getCharacterList(
                pageNumber,
                currentQuery ?: ""
            )
            LoadResult.Page(
                data = response,
                prevKey = if(pageNumber == 1) null else pageNumber - 1,
                nextKey = if (response.isEmpty())  null else pageNumber + 1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
    }
}