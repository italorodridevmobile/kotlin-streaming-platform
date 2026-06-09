package com.kotlin.itmax.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlin.itmax.feature.splash.presentation.ui.SplashScreen

@Composable
fun AppNavigation() {
    // Cria o controlador de navegação
    val navController = rememberNavController()

    // Define o NavHost passando o controlador e a tela inicial (Splash)
    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        // 1. Rota da Splash
        composable<SplashRoute> {
            SplashScreen(
                onNavigateToHome = {
                    // Navega para a Home e limpa a Splash da pilha
                    navController.navigate(HomeRoute) {
                        popUpTo<SplashRoute> { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    // Navega para o Login e limpa a Splash da pilha
                    navController.navigate(LoginRoute) {
                        popUpTo<SplashRoute> { inclusive = true }
                    }
                }
            )
        }

        // 2. Rota de Login (Feature futura)
        composable<LoginRoute> {
            // LoginScreen( onLoginSuccess = { navController.navigate(HomeRoute) } )
        }

        // 3. Rota da Home (Feature futura)
        composable<HomeRoute> {
            // HomeScreen( onMovieClick = { ... } )
        }
    }
}