package upc.edu.pawpointapp.ui.petprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage

// Supongamos que tienes una clase DoctorInfo para almacenar la información del doctor
data class DoctorInfo(
    val name: String,
    val specialty: String,
    val workPlace: String,
    val experienceYears: Int,
    val starRating: Float,
    val description: String,
    val imageUrl: String
)

// Luego, podemos crear un doctor falso para mostrar en la pantalla
val fakeDoctorInfo = DoctorInfo(
    name = "Dr. Alex Zander",
    specialty = "Veterinario - ortopedico",
    workPlace = "Clinica Pet, Lima",
    experienceYears = 5,
    starRating = 4.7f,
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt dui non felis bibendum aliquam.",
    imageUrl = "https://cdn.discordapp.com/attachments/1144828827231592583/1176990568258207784/image.png?ex=6570e0e2&is=655e6be2&hm=b0c464deef6c7bbbc2918a3d6176101c122bed36f7b96d8289e1cf43adaf4352&"
)

@Composable
fun VeterinarianProfile(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF283593))
            .padding(16.dp)
    ) {
        GlideImage(
            imageModel = { fakeDoctorInfo.imageUrl },
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(0.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Nombre del doctor
                Text(
                    text = fakeDoctorInfo.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFBFBFD)
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                // Especialidad del doctor y lugar de trabajo
                Text(
                    text = fakeDoctorInfo.specialty,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFFFBFBFD)
                    ),
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = fakeDoctorInfo.workPlace,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFFFBFBFD)
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Experiencia y calificación del doctor
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    // Icono de experiencia laboral
                    // Reemplaza con tu icono respectivo
                    Text(
                        text = "${fakeDoctorInfo.experienceYears} años",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFFFBFBFD)
                        )
                    )

                    // Icono de calificación
                    // Reemplaza con tu icono respectivo
                    Text(
                        text = "${fakeDoctorInfo.starRating} ★",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFFFBFBFD)
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                // Texto "About Doctor"
                Text(
                    text = "Acerca del Doctor:",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFAFAFC)
                    ),
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
                )

                // Descripción del doctor
                Text(
                    text = fakeDoctorInfo.description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFFFCFCFD)
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Botón de reserva
                Button(
                    onClick = { navController.navigate("AppointmentBooking") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF2AE0E0))
                ) {
                    Text(
                        text = "Hacer reserva de un espacio",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}
