package upc.edu.pawpointapp.ui.petprofile

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.pawpointapp.ui.homepet.HomePetViewModel

@Composable
fun PetProfile(petViewModel: HomePetViewModel) {
    val petId by petViewModel.petId.collectAsState()
    val petDetail by petViewModel.pet.collectAsState()


    LaunchedEffect(petId){
        if(petId!=null){
            petViewModel.getPetDataById(petId)
            Log.d("PetProfile", "corroborar petId: ${petId}")
        }
    }
    if (petDetail!=null){
        Log.d("PetProfile", "petDetail: $petDetail")
        Log.d("PetProfile", "petDetail?.imgUrl: ${petDetail?.imgUrl}")

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3F51B5))

        ) {
            Box( //Foto de la mascota
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                GlideImage(
                    imageModel = {petDetail?.imgUrl.orEmpty()},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .size(250.dp)
                        .padding(16.dp)
                        .clip(CircleShape)
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = petDetail!!.specie,
                        modifier = Modifier.padding(6.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Actualizar foto",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (-30).dp, y = (-15).dp)
                        .clip(CircleShape)
                        .clickable { /*TODO*/ }
                )
            }

            Column ( //Nombre y fecha de nacimiento
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = petDetail!!.name,
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight(700),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                )
                Text(
                    text = "Birthday: ${petDetail!!.dateOfBirth}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
            ) {
                Row(//Datos de la mascota
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Breed", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = petDetail!!.breed, fontSize = 16.sp)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Sex", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = petDetail!!.sex, fontSize = 16.sp)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Age", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "${petDetail!!.age} year", fontSize = 16.sp) //entero
                    }
                }
                Column(//Descripcion
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Description",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = petDetail!!.description,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = "Last Meetings",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        val datesWithDoctors = listOf(
                            "Monday 12/07/2023" to "Dr. John Doe",
                            "Monday 05/07/2023" to "Dr. Jane Smith",
                            "Monday 28/06/2023" to "Dr. Robert Johnson"
                        )
                        Column {
                            datesWithDoctors.forEach { (date, doctor) ->
                                Text(
                                    text = "$date | $doctor",
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
