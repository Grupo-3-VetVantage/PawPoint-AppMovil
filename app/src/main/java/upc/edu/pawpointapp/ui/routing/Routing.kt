package upc.edu.pawpointapp.ui.routing


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.ui.UserProfile.UserProfile
import upc.edu.pawpointapp.ui.appointmentbooking.AppointmentBooking
import upc.edu.pawpointapp.ui.home.Home
import upc.edu.pawpointapp.ui.homepet.HomePet
import upc.edu.pawpointapp.ui.homepet.HomePetViewModel
import upc.edu.pawpointapp.ui.login.Login
import upc.edu.pawpointapp.ui.login.LoginViewModel
import upc.edu.pawpointapp.ui.loginpage.LoginPage
import upc.edu.pawpointapp.ui.petprofile.PetProfile
import upc.edu.pawpointapp.ui.petprofile.VeterinarianProfile
import upc.edu.pawpointapp.ui.petregister.PetRegister
import upc.edu.pawpointapp.ui.petregister.PetRegisterViewModel
import upc.edu.pawpointapp.ui.signup.Signup

@Composable
fun Routing(){
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = viewModel()
    val homePetViewModel: HomePetViewModel = viewModel()
    NavHost(navController = navController, startDestination = "LoginPage" ){

        composable("Signup"){
            Signup(navController,userRepository = UserRepository() )
        }

        composable("LoginPage"){
            LoginPage(navController)
        }

        composable("Login"){
            Login(navController, loginViewModel)
        }

        composable("Home"){
            Home(navController)
        }

        composable("PetProfile/{petId}"){
            PetProfile(homePetViewModel)
        }

        composable("PetRegister"){
            val viewModel: PetRegisterViewModel = viewModel()
            PetRegister(navController, viewModel, loginViewModel)
        }

        composable("HomePet"){
            HomePet(navController, homePetViewModel, loginViewModel)
        }
        composable("VeterinarianProfile") {
            VeterinarianProfile(navController)
        }

        composable("AppointmentBooking") {
            AppointmentBooking(navController)
        }

        composable("UserProfile") {
            UserProfile(navController)
        }

    }

}