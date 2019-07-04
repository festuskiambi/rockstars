package com.example.rockstars.bookmarks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Entity
import com.example.domain.usecase.rockstars.IBookMarkUseCase
import com.example.rockstars.R
import com.example.rockstars.common.AppDispatchers
import com.example.rockstars.common.BaseViewModel
import com.example.rockstars.common.Event
import com.example.domain.common.Result
import kotlinx.coroutines.launch

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class BookmarkViewModel(
    private val iBookMarkUseCase: IBookMarkUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val bookmarksListState = MutableLiveData<List<Entity.RockStar>>()
    val bookmarkList: LiveData<List<Entity.RockStar>> get() = bookmarksListState

    init {
        getBookmarks()
    }

    private fun getBookmarks() = viewModelScope.launch(dispatchers.io) {
        when (val bookmarkResult = iBookMarkUseCase.getBookmarks()) {
            is Result.Value -> bookmarksListState.postValue(bookmarkResult.value)
            is Result.Error -> _snackbarError.postValue(Event(R.string.error))
        }
    }

    fun deleteBookmark(rockStar: Entity.RockStar) = viewModelScope.launch(dispatchers.io) {
        iBookMarkUseCase.deleteBookMark(rockStar)
        getBookmarks()
    }

}