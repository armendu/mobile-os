package com.example.plantapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantapp.Routes
import com.example.plantapp.data.AppDatabase
import com.example.plantapp.data.OfflinePlantsRepository
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navigationController: NavController) {

    val username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Plant App", style = TextStyle(fontSize = 40.sp))

        MySpacer()

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it }
        )

        MySpacer()

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = { Text(text = "Password") },
            value = password.value,
            onValueChange = { password.value = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        MySpacer()

        // TODO: Explain Logging and how to use the text field data
        Button(
//            onClick = { navigationController.navigate(Routes.Content.routeName) },
            onClick = {
                coroutineScope.launch {
                    val repo = AppDatabase.getDatabase(context.applicationContext).plantsDao()
                    repo.insert(com.example.plantapp.data.Plant(1, "Sample Plant Name", "Sample"))
                }
            },
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun MySpacer() {
    val spacerSize = 20.dp
    Spacer(modifier = Modifier.height(spacerSize))
}