package com.taximoto.app.ui.screens.driverregister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun DriverRegisterScreen(
    onBackClick: () -> Unit,
    onRegisterSuccess: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var motorcycleBrand by remember { mutableStateOf("") }
    var motorcycleModel by remember { mutableStateOf("") }
    var plate by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = "REGISTRO DE CONDUCTOR",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                errorMessage = ""
            },
            label = {
                Text("Nombre completo")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
                errorMessage = ""
            },
            label = {
                Text("Número de celular")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
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
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Datos de la motocicleta",
            fontSize = 20.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = motorcycleBrand,
            onValueChange = {
                motorcycleBrand = it
                errorMessage = ""
            },
            label = {
                Text("Marca")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = motorcycleModel,
            onValueChange = {
                motorcycleModel = it
                errorMessage = ""
            },
            label = {
                Text("Modelo")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = plate,
            onValueChange = {
                plate = it.uppercase()
                errorMessage = ""
            },
            label = {
                Text("Placa")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(24.dp)
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

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                errorMessage = ""
            },
            label = {
                Text("Confirmar contraseña")
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

                if (name.isBlank()) {

                    errorMessage = "Ingresa tu nombre completo"

                } else if (phone.isBlank()) {

                    errorMessage = "Ingresa tu número de celular"

                } else if (email.isBlank()) {

                    errorMessage = "Ingresa tu correo electrónico"

                } else if (motorcycleBrand.isBlank()) {

                    errorMessage = "Ingresa la marca de la motocicleta"

                } else if (motorcycleModel.isBlank()) {

                    errorMessage = "Ingresa el modelo de la motocicleta"

                } else if (plate.isBlank()) {

                    errorMessage = "Ingresa la placa"

                } else if (password.length < 6) {

                    errorMessage = "La contraseña debe tener al menos 6 caracteres"

                } else if (password != confirmPassword) {

                    errorMessage = "Las contraseñas no coinciden"

                } else {

                    onRegisterSuccess()
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "REGISTRARME COMO CONDUCTOR"
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "VOLVER"
            )
        }

        Spacer(
            modifier = Modifier.height(32.dp)
        )
    }
}