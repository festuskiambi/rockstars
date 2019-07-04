package com.example.rockstars.profile.viewmodel

import androidx.lifecycle.viewModelScope
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

    fun newUserProfile(pictureUrl: String, name: String) = viewModelScope.launch(dispatchers.io) {
        val user = Entity.User(0, name, pictureUrl)
        iUserUseCase.createOrUpdateUser(user)
    }


}