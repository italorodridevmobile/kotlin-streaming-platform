package com.kotlin.itmax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kotlin.itmax.core.navigation.AppNavigation
import com.kotlin.itmax.core.theme.ItMaxAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItMaxAppTheme {
                AppNavigation();
            }
        }
    }
}
