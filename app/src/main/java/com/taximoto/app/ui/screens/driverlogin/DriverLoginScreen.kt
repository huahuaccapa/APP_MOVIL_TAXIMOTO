package com.taximoto.app.ui.screens.driverlogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DriverLoginScreen(
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "TAXI MOTO",
            fontSize = 34.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Iniciar sesión como conductor",
            fontSize = 20.sp
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
                errorMessage = ""
            },

            label = {
                Text("Correo electrónico")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = password,

            onValueChange = {
                password = it
                errorMessage = ""
            },

            label = {
                Text("Contraseña")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true,

            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        Button(
            onClick = {

                if (email.isBlank()) {

                    errorMessage = "Ingresa tu correo electrónico"

                } else if (password.isBlank()) {

                    errorMessage = "Ingresa tu contraseña"

                } else {

                    onLoginSuccess()
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "INICIAR SESIÓN"
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "¿Aún no eres conductor?"
        )

        TextButton(
            onClick = onRegisterClick
        ) {

            Text(
                text = "REGISTRARME COMO CONDUCTOR"
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "VOLVER"
            )
        }
    }
}