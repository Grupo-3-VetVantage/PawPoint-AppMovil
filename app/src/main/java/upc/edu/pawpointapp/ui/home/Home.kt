package upc.edu.pawpointapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import java.util.*

@Composable
fun Home() {
    var showCalendarDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        // Barra de búsqueda
        HomeSearch(textQuery = remember { mutableStateOf("") })

        // Título "Upcoming appointment"
        Text(
            text = "Upcoming appointment",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        // Card con información del doctor y botón para mostrar el calendario
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),

        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Dr. Alexander")
                Text(text = "Veterinarian Orthopedics")

                // Botón para mostrar el calendario
                TextButton(
                    onClick = {
                        showCalendarDialog = true
                    }
                ) {
                    Text(text = "Mostrar Calendario")
                }
            }
        }
        Text(
            text = "Services",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Row{
            PetShopping (
                buttonText = "Shopping",
                onClick = { /*TODO*/ }
            )
            Veterinary (
                buttonText = "Shopping",
                onClick = { /*TODO*/ }
            )

            PetInformation(
                buttonText = "Information",
                onClick = { /*TODO*/ }
            )
        }
        Text(
            text = "Nearby Veterinarian",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        DoctorListPreview()





        // Diálogo del calendario
        if (showCalendarDialog) {
            CalendarDialog(onDismiss = { showCalendarDialog = false })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearch(
    textQuery: MutableState<String>
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = textQuery.value,
        onValueChange = { newTextQuery ->
            textQuery.value = newTextQuery
        },
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Aquí puedes manejar la acción de búsqueda, pero en esta versión simplificada no hace nada.
            }
        )
    )
}

@Composable
fun PetShopping(
    buttonText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(2.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(120.dp) // Ancho y alto ajustables según tu preferencia
                .padding(4.dp) // Espaciado entre los botones
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary),
            contentPadding = PaddingValues(0.dp)
        ) {
            GlideImage(
                imageModel = {
                    "https://cdn.discordapp.com/attachments/1144828827231592583/1156069418732900363/image.png?ex=6513a10c&is=65124f8c&hm=8dc6af1197aec49b75817e8bac54e0f57cd4e7f98c811cfcd4be831ef6ff824f&"
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                )
            )
        }
        Text(
            text = buttonText,
            fontSize = 14.sp, // Tamaño del texto ajustable
            color = Color.Black,
        )
    }
}
@Composable
fun Veterinary(
    buttonText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(2.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(120.dp) // Ancho y alto ajustables según tu preferencia
                .padding(4.dp) // Espaciado entre los botones
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary),
            contentPadding = PaddingValues(0.dp)
        ) {
            GlideImage(
                imageModel = {
                    "https://cdn.discordapp.com/attachments/1144828827231592583/1156069455227523202/image.png?ex=6513a114&is=65124f94&hm=83ae6e0160d44a70f1543fd96c915ce9fb260619b9a3d1ab7d4fdf1428c37b03&"
                },

                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                )

            )
        }
        Text(
            text = buttonText,
            fontSize = 14.sp, // Tamaño del texto ajustable
            color = Color.Black,
        )
    }
}


@Composable
fun PetInformation(
    buttonText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(2.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(120.dp) // Ancho y alto ajustables según tu preferencia
                .padding(4.dp) // Espaciado entre los botones
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary),
            contentPadding = PaddingValues(0.dp)
        ) {
            GlideImage(
                imageModel = {
                    "https://cdn.discordapp.com/attachments/1144828827231592583/1156069512429436958/image.png?ex=6513a122&is=65124fa2&hm=fd3cb4c261c59a805d551611b349e9b81a23f270dba83ac43fe8d76b6697d135&"
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                )
            )
        }
        Text(
            text = buttonText,
            fontSize = 14.sp, // Tamaño del texto ajustable
            color = Color.Black,
        )
    }
}



@Composable
fun DoctorList(doctors: List<Doctor>) {
    LazyColumn {
        items(doctors) { doctor ->
            DoctorListItem(doctor)
            Divider()
        }
    }
}

@Composable
fun DoctorListItem(doctor: Doctor) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = doctor.name, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = null)
                        Text(text = doctor.rating.toString())
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                        Text(text = "${doctor.distance} km")
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                    }
                }
            }
        }
    }
}

data class Doctor(
    val name: String,
    val rating: Float,
    val distance: Double
)

@Composable
fun DoctorListPreview() {
    val doctors = listOf(
        Doctor("Dr. Smith", 4.5f, 3.2),
        Doctor("Dr. Johnson", 4.8f, 1.5),
        Doctor("Dr. Williams", 4.2f, 2.8)
    )

    DoctorList(doctors = doctors)
}




@Composable
fun CalendarDialog(onDismiss: () -> Unit) {
    // Aquí puedes crear un diálogo para mostrar el calendario
    // Puedes personalizar el diálogo según tus necesidades
    // Recuerda llamar a onDismiss cuando se cierre el diálogo
}

@Preview
@Composable
fun HomePreview() {
    Home()
}
