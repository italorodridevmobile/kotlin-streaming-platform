package com.kotlin.itmax.feature.splash.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.itmax.feature.splash.domain.usecase.CheckUserSessionUseCase
import com.kotlin.itmax.feature.splash.presentation.state.SplashUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkUserSessionUseCase: CheckUserSessionUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Loading)

    init {
        checkSession()
    }

    private fun checkSession() {
        viewModelScope.launch {
            val isLoggedIn = checkUserSessionUseCase()

            if(isLoggedIn) {
                _uiState.value = SplashUiState.NavigateToHome
            } else {
                _uiState.value = SplashUiState.NavigateToLogin
            }
        }
    }
}