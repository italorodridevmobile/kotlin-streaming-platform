package com.kotlin.itmax.feature.splash.presentation.state

class SplashUiState {
    object Loading : SplashUiState // Mostrar logo
    object NavigateToHome : SplashUiState // Usuario logado
    object NavigateToLogin : SplashUiState // Usuario nao logado
}