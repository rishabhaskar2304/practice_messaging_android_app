package com.bms.mobile.application.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
public fun WelcomeView(modifier: Modifier = Modifier, username: String, userid: String, emailid: String) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Row {
            Column {
                Text("Name", Modifier.padding(all = 18.dp))
                Text("Email Address", Modifier.padding(all = 18.dp))
                Text("UserId", Modifier.padding(all = 18.dp))
            }

            Column {
                Text(username, Modifier.padding(all = 18.dp))
                Text(emailid, Modifier.padding(all = 18.dp))
                Text(userid, Modifier.padding(all = 18.dp))
            }
        }
    }
}
