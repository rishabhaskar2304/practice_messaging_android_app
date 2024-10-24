package com.bms.mobile.application.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.bms.mobile.application.ui.theme.BMSMobileApplicationTheme
import com.bms.mobile.application.view.WelcomeView

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username")!!
        val userId = intent.getStringExtra("userid")!!
        val emailId = intent.getStringExtra("emailid")!!

        enableEdgeToEdge()
        setContent {
            BMSMobileApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        innerPadding ->
                    WelcomeView(Modifier.padding(innerPadding),
                        username,
                        userId,
                        emailId
                    )
                }
            }
        }
    }
}