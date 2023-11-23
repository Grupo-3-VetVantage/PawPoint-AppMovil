package upc.edu.pawpointapp.ui.viewVet;

import android.util.Log
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun ViewVet (navController: NavController, viewVetModel: ViewVetModel){
    val vetList by viewVetModel.vetList.collectAsState()

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
            viewVetModel.getVetList {}
            itemsIndexed(vetList) { index, vetList->
                Log.d("VetProfile", "Selected vetId: ${vetList.id}")
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row( modifier = Modifier .padding(16.dp)) {
                        VetImage(viewVetModel, index)
                        Column {
                            Text(
                                text = "Name: ${vetList.name}",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Speciality: ${vetList.speciality}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Phone: ${vetList.phone}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Description: ${vetList.description}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Address: ${vetList.address}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF4285F4),
                                    textAlign = TextAlign.Center
                                )
                            )



                        }
                        IconButton(onClick = {
                            /**
                            viewVetModel.setVetId(vetList.id)
                            navController.navigate("VetProfile/${vetList.id}") */}

                        ) {
                            Icon(
                                Icons.Default.ArrowForward, contentDescription = null,
                            )
                        }
                    }

                }
            }
        }
        )
    }
}

@Composable
fun VetImage(viewVetModel: ViewVetModel, index: Int){
    val vet by viewVetModel.vetList.collectAsState()
    GlideImage(
        imageModel = { vet[index].imgUrl},
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier
            .size(92.dp)
    )
}