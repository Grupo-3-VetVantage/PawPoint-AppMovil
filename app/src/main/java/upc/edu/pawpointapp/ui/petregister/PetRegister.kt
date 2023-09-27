package upc.edu.pawpointapp.ui.petregister

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ColorLens
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetRegister(navController: NavController){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var petcolor by remember { mutableStateOf("") }
    var petweight by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var specie by remember { mutableStateOf("") }



    Box(
        modifier = Modifier
            .background(Color(63, 81, 181))
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

    ){
/*
        GlideImage(
            imageModel = { "https://i.ibb.co/7S60pf5/captureimage.png" },
            imageOptions = ImageOptions(contentScale = ContentScale.Fit),
            modifier = Modifier
                .width(50.dp)
                .height(100.dp)
        )*/
        Surface (
            modifier = Modifier
                .offset(y=200.dp),
            shape = RoundedCornerShape(50.dp)
        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 20.dp),
                verticalArrangement= Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){

                Text(
                    text = "Name",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = name ,
                    onValueChange = {name = it},
                    placeholder = {Text("E.g: Louis", style = TextStyle(color = Color(151,148,148)))},
                    textStyle = TextStyle(textAlign = TextAlign.Left),
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Pets, contentDescription = "Name", tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Age",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = age ,
                    onValueChange = {age = it},
                    placeholder = {Text("E.g: 5",style = TextStyle(color = Color(151,148,148)))},
                    textStyle = TextStyle(textAlign = TextAlign.Left),
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Color",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = petcolor ,
                    onValueChange = {petcolor = it},
                    placeholder = {Text("E.g: Black",style = TextStyle(color = Color(151,148,148)))},
                    textStyle = TextStyle(textAlign = TextAlign.Left),
                    trailingIcon = { Icon(imageVector = Icons.Outlined.ColorLens, contentDescription = "Color", tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Weight",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = petweight ,
                    onValueChange = {petweight = it},
                    placeholder = {Text("E.g: 20kg",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.MonitorWeight, contentDescription = "Weight",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Date of Birth",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = dateOfBirth ,
                    onValueChange = {dateOfBirth = it},
                    placeholder = {Text("E.g: 30/10/2021",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.CalendarMonth, contentDescription = "Date", tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Description",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = description ,
                    onValueChange = {description = it},
                    placeholder = {Text("E.g: A little pet",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Description, contentDescription = "Description",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "ImageUrl",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = imageUrl ,
                    onValueChange = {imageUrl = it},
                    placeholder = {Text("Image",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Image, contentDescription = "Image",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Gender",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = sex ,
                    onValueChange = {sex = it},
                    placeholder = {Text("E.g: Male",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Pets, contentDescription = "Sex",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Breed",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = breed ,
                    onValueChange = {breed = it},
                    placeholder = {Text("E.g: Beagle",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Pets, contentDescription = "Breed",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Specie",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(bottom = 4.dp, start = 50.dp).align(Alignment.Start)
                )
                OutlinedTextField(
                    value = specie ,
                    onValueChange = {specie = it},
                    placeholder = {Text("Eg: Dog",style = TextStyle(color = Color(151,148,148)))},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Pets, contentDescription = "Specie",tint = Color(151,148,148))},
                    modifier = Modifier.border(1.dp, Color(216,218,220))
                )
                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                        //logic
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(Color(40,53,147))
                        .fillMaxWidth(0.6f)

                ) {
                    Text("Add Pet")
                }
            }
        }
    }
}

