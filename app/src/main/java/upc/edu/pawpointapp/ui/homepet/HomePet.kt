package upc.edu.pawpointapp.ui.homepet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.pawpointapp.ui.login.LoginViewModel

@Composable
fun HomePet(navController: NavController, homePetViewModel: HomePetViewModel, loginViewModel: LoginViewModel) {
    val userId by loginViewModel.logged.collectAsState()
    val pet by homePetViewModel.petList.collectAsState()


    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
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
        LazyColumn(content = {
            homePetViewModel.getPetLIst(userId){}
            itemsIndexed(pet) { index, pet->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row( modifier = Modifier .padding(16.dp)) {
                        PetImage(homePetViewModel, index)
                        Column {
                            Text(
                                text = "Name: ${pet.name}",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Gender: ${pet.sex}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Color: ${pet.color}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )



                        }
                        IconButton(onClick = { navController.navigate("PetProfile") }                        ) {
                            Icon(
                                Icons.Default.ArrowForward, contentDescription = null,
                            )
                        }
                    }

                }
            }
        }
        )

        IconButton(onClick = { navController.navigate("PetRegister") },
                modifier = Modifier
            .padding(16.dp)
        ) {
            Icon(
                Icons.Default.Add ,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        Color(0xFF4285F4),
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
                    .padding(5.dp)
                    .width(48.dp)
                    .height(48.dp)
                    .shadow(
                        elevation = 13.dp,
                        spotColor = Color(0x6976655A),
                        ambientColor = Color(0x6976655A)
                    )

            )
        }
    }

}

@Composable
fun PetImage(homePetViewModel: HomePetViewModel, index: Int){
    val pet by homePetViewModel.petList.collectAsState()
    GlideImage(
        imageModel = { pet[index].imgUrl},
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier
            .size(92.dp)
    )
}
