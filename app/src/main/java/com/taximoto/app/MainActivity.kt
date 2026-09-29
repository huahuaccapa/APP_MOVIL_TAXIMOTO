package com.taximoto.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.taximoto.app.navigation.AppNavigation
import com.taximoto.app.ui.theme.TaxiMotoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            TaxiMotoTheme {

                AppNavigation()

            }
        }
    }
}