package com.example.rockstars.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.usecase.user.IUserUseCase
import com.example.rockstars.common.AppDispatchers
import com.example.rockstars.common.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Festus Kiambi on 7/4/19.
 */
class UserProfileViewModel(
    private val iUserUseCase: IUserUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {
    private val userState = MutableLiveData<Entity.User>()
    val user: LiveData<Entity.User> get() = userState

    init {
        /**
         * Since we don't have authentication yet we will assume the user has an id of zero
         * */
        getUser(0)
    }

  private fun getUser(userId: Int) = viewModelScope.launch(dispatchers.io) {

     when (val userResult = iUserUseCase.getUserById(userId)) {
            is Result.Value -> userState.postValue(userResult.value)
        }
    }

    fun newUserProfile(pictureUrl: String, name: String) = viewModelScope.launch(dispatchers.io) {
        val user = Entity.User(0, name, pictureUrl)
        iUserUseCase.createOrUpdateUser(user)
        getUser(0)
    }
}