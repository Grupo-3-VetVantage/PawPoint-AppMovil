package upc.edu.pawpointapp.ui.appointmentbooking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.google.type.Date
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentBooking(navController: NavController) {
    var showAlert by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }
    var serviceType by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable { showAlert = false },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                GlideImage(
                    imageModel = {
                        "https://www.triada.com.pe/noticias/wp-content/uploads/2022/05/MascotasHuesito-1210x700.jpg"
                    },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                    )
                )            }

            CardWithTitle("Fecha y Hora", Icons.Filled.CalendarToday) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    TextField(
                        value = selectedDate,
                        onValueChange = { selectedDate = it },
                        label = { Text("Fecha") },
                        modifier = Modifier.weight(1f).padding(end = 8.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )

                    TextField(
                        value = selectedTime,
                        onValueChange = { selectedTime = it },
                        label = { Text("Hora") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )
                }
            }

            CardWithTitle("Servicio", Icons.Filled.ChevronRight) {
                OutlinedTextField(
                    value = serviceType,
                    onValueChange = { serviceType = it },
                    label = { Text("Tipo de servicio") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)

                )
            }

            CardWithTitle("Descripción de cita", Icons.Filled.Book) {
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Escribe aquí...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }



            Button(
                onClick = { showAlert = true },
                modifier = Modifier

                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Enviar Solicitud de Cita")
            }
        }

        if (showAlert) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(75.dp)
                                .clip(CircleShape)
                                .background(Color.White)


                            ) {
                            // Cargar la imagen de la mascota con GlideImage
                            GlideImage(
                                        imageModel = {
                                    "https://cdn.discordapp.com/attachments/1144828827231592583/1177031977690468373/image.png?ex=65710773&is=655e9273&hm=fabb1f02a59806a99c9ceb8256229f4d8934c65f7cc577a38ba9fbb10f8a2d39&"
                                },
                                imageOptions = ImageOptions(
                                    contentScale = ContentScale.Crop,

                                )
                            )
                        }
                        Text(
                            text = "Se registró correctamente",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 8.dp),
                            color = Color.White // Color del texto

                        )
                    }
                }
            }
        }




    }
}

@Composable
fun CardWithTitle(title: String, icon: ImageVector, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(imageVector = icon, contentDescription = null)
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            content()
        }
    }
}
