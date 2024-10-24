package com.bms.mobile.application.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bms.mobile.application.client.BmsClient
import com.message.v1.RegisterResponse
import kotlinx.coroutines.launch

@Composable
fun Register(modifier: Modifier = Modifier, onRegister:(RegisterResponse) -> Unit) {
    var nameValue by remember { mutableStateOf("") }
    var emailAddressValue by remember { mutableStateOf("") }
    val registerClient = remember { BmsClient() }

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Row {
            Column {
                Text("Name", Modifier.padding(all = 18.dp))
                Text("Email Address", Modifier.padding(all = 18.dp))
            }

            Column {
                OutlinedTextField (nameValue, onValueChange = {nameValue = it}
                    , Modifier.padding(end = 10.dp))

                OutlinedTextField(emailAddressValue, onValueChange = {emailAddressValue = it}
                    , Modifier.padding(end = 10.dp))
            }
        }

        val coroutineScope = rememberCoroutineScope()

        val registerUserOnClick:() -> Unit = {
            coroutineScope.launch {
                try {
                    val registerResponse = registerClient.register(nameValue, emailAddressValue)
                    onRegister(registerResponse)
                } catch (e: Exception) {
                    println("Some error has been faced $e")
                }
            }
        }

        Button(onClick = {registerUserOnClick()}, colors = ButtonColors(contentColor = Color.Black, containerColor = Color.Green, disabledContentColor = Color.Black, disabledContainerColor = Color.Green)) {
            Text("Register")
        }
    }
}
