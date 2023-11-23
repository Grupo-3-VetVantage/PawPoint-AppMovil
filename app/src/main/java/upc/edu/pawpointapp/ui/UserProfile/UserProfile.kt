package upc.edu.pawpointapp.ui.UserProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserProfile(navController: NavController) {
    val userProfileImage = "https://example.com/user_profile_image.jpg"
    val userName = "John"
    val userLastName = "Doe"
    val userAddress = "123 Main St, City"
    val userAge = 30
    val numberOfPets = 2 // Número de mascotas del usuario

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de perfil
        Card(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
        ) {
            GlideImage(
                imageModel = { userProfileImage},
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
        }

        // Nombre y apellido
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Name: $userName $userLastName")
            }
        }

        // Dirección
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Address: $userAddress")
            }
        }

        // Edad
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Age: $userAge")
            }
        }

        // Número de mascotas
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Number of Pets: $numberOfPets")
            }
        }
    }
}
