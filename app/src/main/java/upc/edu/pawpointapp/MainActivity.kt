package upc.edu.pawpointapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import upc.edu.pawpointapp.ui.home.Home

import upc.edu.pawpointapp.ui.loginpage.LoginPage
import upc.edu.pawpointapp.ui.petprofile.PetProfile
import upc.edu.pawpointapp.ui.petregister.PetRegister
import upc.edu.pawpointapp.ui.routing.Routing

import upc.edu.pawpointapp.ui.theme.PawPointAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawPointAppTheme {
                // A surface container using the 'background' color from the theme
                    Routing()
            }
        }
    }
}
