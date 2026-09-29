package com.taximoto.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.taximoto.app.ui.screens.passengerregister.PassengerRegisterScreen
import androidx.navigation.compose.rememberNavController
import com.taximoto.app.ui.screens.driverlogin.DriverLoginScreen
import com.taximoto.app.ui.screens.passengerlogin.PassengerLoginScreen
import com.taximoto.app.ui.screens.welcome.WelcomeScreen
import com.taximoto.app.ui.screens.driverregister.DriverRegisterScreen
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {

        composable("welcome") {

            WelcomeScreen(
                onPassengerClick = {
                    navController.navigate("passenger_login")
                },

                onDriverClick = {
                    navController.navigate("driver_login")
                }
            )
        }

        composable("passenger_login") {

            PassengerLoginScreen(

                onBackClick = {
                    navController.popBackStack()
                },

                onRegisterClick = {
                    navController.navigate("passenger_register")
                },

                onLoginSuccess = {
                    // Más adelante irá al mapa del pasajero
                }
            )
        }

        composable("driver_login") {

            DriverLoginScreen(

                onBackClick = {
                    navController.popBackStack()
                },

                onRegisterClick = {
                    navController.navigate("driver_register")
                },

                onLoginSuccess = {
                    // Más adelante irá al panel del conductor
                }
            )
        }

        composable("passenger_register") {

            PassengerRegisterScreen(

                onBackClick = {
                    navController.popBackStack()
                },

                onRegisterSuccess = {
                    navController.popBackStack()
                }
            )
        }

        composable("driver_register") {

            DriverRegisterScreen(

                onBackClick = {
                    navController.popBackStack()
                },

                onRegisterSuccess = {
                    navController.popBackStack()
                }
            )
        }
    }
}