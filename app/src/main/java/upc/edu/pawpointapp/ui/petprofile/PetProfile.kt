package upc.edu.pawpointapp.ui.petprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PetProfile(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3F51B5))

    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
        ){
            GlideImage(
                imageModel = {"https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_square.jpg"},
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Actualizar foto",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (-30).dp, y = (-15).dp)
                    .clickable { /*TODO*/ }
            )
        }

        Text(
            text = "Bingo",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )
        Text(
            text = "Birthday: 12/01/2023",
            style = TextStyle(
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            ),
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Specie", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Caninus Domesticus", fontSize = 16.sp)
                    Text(text = "Breed", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Rottweiler", fontSize = 16.sp)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Sex", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Male", fontSize = 16.sp)
                    Text(text = "Age", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "1 year", fontSize = 16.sp)
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Description",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "I'm a lively Rottweiler with a dark coat, " +
                            "bringing joy, playfulness, and loyalty to my home.",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp))
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Last Meetings",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
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
@Composable
fun KeyValueItem(key: String, value: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = key,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = value,
            fontSize = 16.sp,
        )
    }
}
