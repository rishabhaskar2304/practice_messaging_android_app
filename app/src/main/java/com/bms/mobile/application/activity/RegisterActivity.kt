package com.bms.mobile.application.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.bms.mobile.application.ui.theme.BMSMobileApplicationTheme
import com.bms.mobile.application.view.Register

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        enableEdgeToEdge()
        setContent {
            BMSMobileApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        innerPadding ->
                    Register(modifier = Modifier.padding(innerPadding)) {
                        sharedPreferences.edit().apply {
                            putBoolean("isRegistered", true)
                            putString("username", it.name)
                            putString("userid", it.userId)
                            putString("emailid", it.emailId)
                            apply()
                        }

                        val intent = Intent(this, WelcomeActivity::class.java)
                        intent.putExtra("username", it.name)
                        intent.putExtra("userid", it.userId)
                        intent.putExtra("emailid", it.emailId)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}
