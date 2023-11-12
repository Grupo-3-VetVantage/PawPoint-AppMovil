package upc.edu.pawpointapp.ui.petregister

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ColorLens
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.ui.login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledOutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    trailingIcon: ImageVector? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy((-20).dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            trailingIcon = {
                trailingIcon?.let { icon ->
                    Icon(imageVector = icon, contentDescription = label)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun PetRegister(navController: NavController, petviewModel: PetRegisterViewModel, loginViewModel: LoginViewModel){
    val imageUrl1 = {"https://i.ibb.co/Lpsfc5p/patitas.png"}
    val name= remember { mutableStateOf("") }
    val age = remember { mutableStateOf<Int>(5) }
    val petcolor = remember { mutableStateOf("") }
    val petweight = remember { mutableStateOf<Int>(5) }
    val dateOfBirth = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val image = remember { mutableStateOf("https://pm1.aminoapps.com/6538/527fceb688603a8ba94bc4ac369b6e46ef96fdbd_00.jpg") }
    val sex = remember { mutableStateOf("") }
    val breed = remember { mutableStateOf("") }
    val specie = remember { mutableStateOf("") }
    var userId:Int = 0

    fun userIdvalue(onUserIdReady: () -> Unit){
        if (loginViewModel.isLogged()) {
            userId = loginViewModel.getLogged()
            Log.d("userIdvalue", "is logged $userId")
        }
        onUserIdReady()
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3F51B5))

    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            GlideImage(
                imageModel = imageUrl1,
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Upload photo",
                tint = Color.Black,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
                    .offset(y = 20.dp)
                    .clickable { }
            )

        }
    }

    val fields = listOf(
        Triple("Name", name.value, Icons.Outlined.Pets),
        Triple("Age", age.value.toString(), null),
        Triple("Color", petcolor.value, Icons.Outlined.ColorLens),
        Triple("Weight", petweight.value.toString(), Icons.Outlined.MonitorWeight),
        Triple("Birth", dateOfBirth.value, Icons.Outlined.CalendarMonth),
        Triple("Sex", sex.value, Icons.Outlined.Pets),
        Triple("Breed", breed.value, Icons.Outlined.Pets),
        Triple("Specie", specie.value, Icons.Outlined.Pets),
        Triple("Description", description.value, Icons.Outlined.Description)
    )

    Surface(
        modifier = Modifier
          .offset(y = 200.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                for (i in 0 until 4) {
                    val fieldIndex = i
                    if (fieldIndex < fields.size) {
                        val (label, value, icon) = fields[fieldIndex]
                        LabeledOutlinedTextField(
                            label = label,
                            value = value,
                            onValueChange = {
                                when (fieldIndex) {
                                    0 -> name.value = it
                                    1 -> age.value = it.toInt()
                                    2 -> petcolor.value = it
                                    3 -> petweight.value = it.toInt()
                                }
                            },
                            placeholder = " ",
                            trailingIcon = icon,

                            )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                for (i in 4 until 8) {
                    val fieldIndex = i
                    if (fieldIndex < fields.size) {
                        val (label, value, icon) = fields[fieldIndex]
                        LabeledOutlinedTextField(
                            label = label,
                            value = value,
                            onValueChange = {
                                when (fieldIndex) {
                                    4 -> dateOfBirth.value = it
                                    5 -> sex.value = it
                                    6 -> breed.value = it
                                    7 -> specie.value = it
                                }
                            },
                            placeholder = " ", //"E.g: $label",
                            trailingIcon = icon
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .offset(y = 320.dp)
                .padding(10.dp)
        ) {
            val fieldIndex = 8
            if (fieldIndex < fields.size) {
                val (label, value, icon) = fields[fieldIndex]
                LabeledOutlinedTextField(
                    label = label,
                    value = value,
                    onValueChange = {
                        when (fieldIndex) {
                            8 -> description.value = it
                        }
                    },
                    placeholder = " ",
                    trailingIcon = icon
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            Log.d("Pet", "pet descripcion: ${description.value}, ${age.value}, ${petweight.value}, ${name.value}")
        }
    }
    Spacer(modifier = Modifier.width(10.dp))
    TextButton(
        onClick = {
            if (name.value.isNotEmpty() && petcolor.value.isNotEmpty() && dateOfBirth.value.isNotEmpty()
                 && breed.value.isNotEmpty() && specie.value.isNotEmpty() && description.value.isNotEmpty()) {
                userIdvalue{
                    val petRegister = PetRegister(name.value,age.value,petcolor.value,petweight.value,dateOfBirth.value,
                        description.value,image.value,sex.value,breed.value,specie.value, userId)
                    petviewModel.register(petRegister) {result->
                        if(result){
                            navController.navigate("Home")
                        }else{
                            Log.d("Loginclick", "is not login success $userId")
                        }
                    }
                }
            } else {
                Log.d("PetRegister", "empty values")
                //snackbarText = "Por favor, complete todos los campos."
            }
        },
        modifier = Modifier
            .width(320.dp)
            .height(56.dp)
            .offset(x=20.dp, y=600.dp)
            .background(color = Color(0xFF283593), shape = RoundedCornerShape(size = 15.dp))
    ) {
        Text(text = "Add Pet", color = Color.White)
    }

}


