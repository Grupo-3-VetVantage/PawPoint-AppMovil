package upc.edu.pawpointapp.ui.loginpage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.pawpointapp.ui.login.Login
import upc.edu.pawpointapp.ui.signup.Signup


@Composable
fun LoginPage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        GlideImage(
            imageModel = { "https://cdn.discordapp.com/attachments/1154594922339516427/1154595292822376528/Beagle_dog_sitting.png" },
            imageOptions = ImageOptions(contentScale = ContentScale.Fit),
            modifier = Modifier
                .width(213.dp)
                .height(284.dp)
        )
        Text(
            text = "Hey Welcome to Pet World !",
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight(700),

                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = "while you sit and stay - we’ll go out and play",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center
            )

        )
        Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            TextButton(
                onClick = { }, modifier = Modifier
                    .width(320.dp)
                    .height(56.dp)
                    .padding(top = 16.dp, end = 8.dp)
                    .background(color = Color(0xFF283593), shape = RoundedCornerShape(size = 10.dp))


            ) {
                Text(text = "Sign In", color = Color.White)
            }
            TextButton(
                onClick = { }, modifier = Modifier
                    .padding(top = 16.dp, end = 8.dp)
                    .width(320.dp)
                    .height(56.dp)
                    .border(1.dp, Color(0xFF000000), RoundedCornerShape(8.dp))
            ) {
                Text(text = "Create Account", color = Color.Black)
            }
        }
    }
}