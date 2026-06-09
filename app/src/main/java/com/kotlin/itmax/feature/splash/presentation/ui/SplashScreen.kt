package com.kotlin.itmax.feature.splash.presentation.ui

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.kotlin.itmax.feature.splash.presentation.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    // Observamos o estado vindo do ViewModel
    val uiState by viewModel.uiState.collectAsState()

    // O LaunchedEffect reage a mudanças de estado fora da construção da UI (efeitos colaterais)
    LaunchedEffect(key1 = uiState) {
        when (uiState) {
            is SplashUiState.NavigateToHome -> onNavigateToHome()
            is SplashUiState.NavigateToLogin -> onNavigateToLogin()
            is SplashUiState.Loading -> {
                // Apenas aguarda, a interface abaixo está sendo exibida
            }
        }
    }

    // A Interface Visual da sua Splash (Fundo escuro, logo vermelha, bem padrão streaming)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414)), // Cor de fundo estilo Netflix
        contentAlignment = Layout.Alignment.Center
    ) {
        Text(
            text = "STREAMING APP",
            color = Color(0xFFE50914), // Vermelho clássico
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}