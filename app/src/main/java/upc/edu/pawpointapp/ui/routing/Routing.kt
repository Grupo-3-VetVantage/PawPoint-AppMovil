package upc.edu.pawpointapp.ui.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.ui.home.Home
import upc.edu.pawpointapp.ui.homepet.HomePet
import upc.edu.pawpointapp.ui.login.Login
import upc.edu.pawpointapp.ui.loginpage.LoginPage
import upc.edu.pawpointapp.ui.petprofile.PetProfile
import upc.edu.pawpointapp.ui.petregister.PetRegister
import upc.edu.pawpointapp.ui.signup.Signup

@Composable
fun Routing(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LoginPage" ){

        composable("Signup"){
            Signup(navController, userRepository = UserRepository())
        }

        composable("LoginPage"){
            LoginPage(navController)
        }

        composable("Login"){
            Login(navController)
        }

        composable("Home"){
            Home(navController)
        }

        composable("PetProfile"){
            PetProfile(navController)
        }

        composable("PetRegister"){
            PetRegister(navController)
        }

        composable("HomePet"){
            HomePet(navController)
        }

    }

}