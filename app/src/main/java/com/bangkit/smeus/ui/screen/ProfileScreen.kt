package com.bangkit.smeus.ui.screen

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.smeus.ui.components.ButtonForm
import com.bangkit.smeus.ui.components.InputForm
import com.bangkit.smeus.ui.main.Main

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
    ) {
        val context = LocalContext.current

        var name by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var phone by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var confirmPassword by rememberSaveable { mutableStateOf("") }

        var nameErrorText by rememberSaveable { mutableStateOf("") }
        var emailErrorText by rememberSaveable { mutableStateOf("") }
        var phoneErrorText by rememberSaveable { mutableStateOf("") }
        var passwordErrorText by rememberSaveable { mutableStateOf("") }
        var confirmPasswordErrorText by rememberSaveable { mutableStateOf("") }

        Text(
            text = "Profile",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = "edit your profile",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.padding(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(bottom = 8.dp)
        ) {
            InputForm(
                text = name,
                label = "Name",
                errorText = nameErrorText,
                onValueChange = {
                    name = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                }
            )
            InputForm(
                text = email,
                label = "Email",
                errorText = emailErrorText,
                onValueChange = {
                    email = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "")
                }
            )
            InputForm(
                text = phone,
                label = "Phone",
                errorText = phoneErrorText,
                onValueChange = {
                    phone = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                }
            )
            InputForm(
                text = password,
                label = "Password",
                errorText = passwordErrorText,
                onValueChange = {
                    password = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                }
            )
            InputForm(
                text = confirmPassword,
                label = "Confirm Password",
                errorText = confirmPasswordErrorText,
                onValueChange = {
                    confirmPassword = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                }
            )
        }
        ButtonForm(
            text = "Save Profile",
            color = Color.Blue,
            onClick = {
                var valid = true

                if (name == "") {
                    nameErrorText = "Password cannot be null"
                } else {
                    nameErrorText = ""
                }

                if (email == "") {
                    emailErrorText = "Password cannot be null"
                } else {
                    emailErrorText = ""
                }

                if (phone == "") {
                    phoneErrorText = "Password cannot be null"
                } else {
                    phoneErrorText = ""
                }

                if (password == "") {
                    passwordErrorText = "Password cannot be null"
                } else {
                    passwordErrorText = ""
                }

                if (confirmPassword == "") {
                    confirmPasswordErrorText = "Password cannot be null"
                } else {
                    confirmPasswordErrorText = ""
                }

                if (confirmPassword != password) {
                    confirmPasswordErrorText =
                        "Password must be the same with Confirmation Password"
                }

                if (name == "" || email == "" || phone == "" || password == "" || confirmPassword == "" || password != confirmPassword) {
                    valid = false
                }

                if (valid) {
                    Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT).show()
                    val activity = (context as Activity)
                    activity.finish()
                } else {
                    Toast.makeText(context, "Registered Unsuccessful", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            ProfileScreen()
        }
    }
}