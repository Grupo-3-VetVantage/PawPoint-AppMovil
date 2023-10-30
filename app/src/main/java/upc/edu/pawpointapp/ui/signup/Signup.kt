package upc.edu.pawpointapp.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.livedata.observeAsState
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signup(navController: NavController) {
    val viewModel: SignUpViewModel = SignUpViewModel()

    val FirstName : String by viewModel.firstName.observeAsState("")
    val Username: String by viewModel.username.observeAsState("")
    val Password: String by viewModel.password.observeAsState("")
    val Email: String by viewModel.email.observeAsState("")
    var showPassword by remember { mutableStateOf(value = false) }


    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {navController.navigate("LoginPage") }) {
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

        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp, horizontal = 10.dp)
                    ,
                horizontalArrangement = Arrangement.Start,

            ) {
                Text(
                    text = "Create account",
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
            Text(
                text = "Please fill your details",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 50.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA1A1A1),
                    textAlign = TextAlign.Center,


                ),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .height(50.dp))

        }

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            OutlinedTextField(
                value = FirstName,
                onValueChange = { newValue ->
                    viewModel.updateFirstName(newValue)

                },

                label = { Text("Name") },
                placeholder = { Text("Jhon Don") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)

            )

            OutlinedTextField(
                value = Username,
                onValueChange = { newValue ->
                    viewModel.updateUsername(newValue)

                },

                label = { Text("User Name") },
                placeholder = { Text("") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)

            )

            OutlinedTextField(
                value = Email,
                onValueChange = { newValue ->
                    viewModel.updateEmail(newValue)

                },

                label = { Text("Email") },
                placeholder = { Text("jhon@email.com") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)

            )
            OutlinedTextField(
                value = Password,
                onValueChange = { newValue ->
                    viewModel.updatePassword(newValue)

                },
                visualTransformation =if (showPassword) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()

                },

                label = { Text("Create Password") },
                placeholder = { Text("must be 8 characters") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
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
                    viewModel.register()

                    }, modifier = Modifier
                    .width(320.dp)
                    .height(56.dp)
                    .padding(top = 16.dp, end = 8.dp)
                    .background(color = Color(0xFF283593), shape = RoundedCornerShape(size = 10.dp))


            ) {
                Text(text = "Create Account", color = Color.White)


            }
        }
    }

}
