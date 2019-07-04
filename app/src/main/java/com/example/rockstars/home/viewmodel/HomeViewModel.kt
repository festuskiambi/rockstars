package com.example.rockstars.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.usecase.rockstars.IBookMarkUseCase
import com.example.domain.usecase.rockstars.IRockStarUseCase
import com.example.rockstars.R
import com.example.rockstars.common.AppDispatchers
import com.example.rockstars.common.BaseViewModel
import com.example.rockstars.common.Event
import kotlinx.coroutines.launch

/**
 * Created by Festus Kiambi on 7/2/19.
 */
class HomeViewModel(
    private val iRockStarUseCase: IRockStarUseCase,
    private val iBookMarkUseCase: IBookMarkUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val rockStarsListState = MutableLiveData<List<Entity.RockStar>>()
    val rockStarsList: LiveData<List<Entity.RockStar>> get() = rockStarsListState

    init {
        getRockStars()
    }

    private fun getRockStars() = viewModelScope.launch(dispatchers.main) {

        when (val rockStarResult = iRockStarUseCase.getRockStars()) {
            is Result.Value -> rockStarsListState.value = rockStarResult.value
            is Result.Error -> _snackbarError.value = Event(R.string.error)
        }
    }

    fun addBookMark(rockStar: Entity.RockStar) = viewModelScope.launch(dispatchers.io){
      iBookMarkUseCase.createBookMark(rockStar)
    }

}