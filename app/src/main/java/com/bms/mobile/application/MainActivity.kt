package com.bms.mobile.application

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bms.mobile.application.activity.RegisterActivity
import com.bms.mobile.application.activity.WelcomeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        val isRegistered = sharedPreferences.getBoolean("isRegistered", false)

        enableEdgeToEdge()
        setContent {
            if (isRegistered) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", sharedPreferences.getString("username", "")!!)
                intent.putExtra("userid", sharedPreferences.getString("userid", "")!!)
                intent.putExtra("emailid", sharedPreferences.getString("emailid", "")!!)
                startActivity(intent)
                finish()
            } else {
                startActivity(Intent(this, RegisterActivity::class.java))
                finish()
            }
//            BMSMobileApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    innerPadding ->
//                    Greeting(
//                        name = "Rishabh",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    Register(modifier = Modifier.padding(innerPadding))
//                }
//            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RegisterPreview() {
//    Register()
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BMSMobileApplicationTheme {
//        Greeting("Android")
//    }
//}

