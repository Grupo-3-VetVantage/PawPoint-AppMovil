package upc.edu.pawpointapp.ui.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import upc.edu.pawpointapp.data.model.User.UserLogin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, viewModel: LoginViewModel) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(value = false) }
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("LoginPage") }) {
                Icon(
                    Icons.Default.ArrowBack, contentDescription = null,
                )
            }

            Text(
                text = "Back",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF4285F4),
                    textAlign = TextAlign.Center
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome to PawPoint!",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 31.2.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "🐶",
                style = TextStyle(
                    fontSize = 32.sp,
                    lineHeight = 43.2.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },

                label = { Text("Email") },
                placeholder = { Text("jhon@example.com") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)

            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                visualTransformation =if (showPassword) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()

                },

                label = { Text("Password") },
                placeholder = { Text("Password") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 40.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "hide_password"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { showPassword = true }) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = "hide_password"
                            )
                        }
                    }
                }
            )

            TextButton(
                onClick = {
                    if (email.value.isNotEmpty() && password.value.isNotEmpty() ) {
                        val userLogin = UserLogin(email.value, password.value)
                        viewModel.login(userLogin){logginSucces->
                            if(logginSucces){
                                Log.d("Loginclick", "email actual: ${email.value}")
                                navController.navigate("Home")
                            }else{
                                Log.d("Loginclick", "no es loggin succes: ${email.value}")
                            }
                        }

                    } else {
                        //snackbarText = "Por favor, complete todos los campos."
                        Log.d("Loginclick", "campos incompletos")
                    }
                }, modifier = Modifier
                    .width(320.dp)
                    .height(56.dp)
                    .padding(top = 16.dp, end = 8.dp)
                    .background(color = Color(0xFF283593), shape = RoundedCornerShape(size = 10.dp))


            ) {
                Text(text = "Sign In", color = Color.White)


            }
        }
    }



}

