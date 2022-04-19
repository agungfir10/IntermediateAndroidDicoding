package com.agungfir.animation.view.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agungfir.animation.model.UserModel
import com.agungfir.animation.model.UserPreference
import kotlinx.coroutines.launch

class RegisterViewModel(private val pref: UserPreference) : ViewModel() {
    fun saveUser(user: UserModel) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}