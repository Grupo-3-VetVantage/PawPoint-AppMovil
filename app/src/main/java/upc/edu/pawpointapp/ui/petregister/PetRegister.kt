package upc.edu.pawpointapp.ui.petregister

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

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

@Preview
@Composable
fun LabeledOutlinedTextFieldPreview() {
    LabeledOutlinedTextField(
        label = "Name",
        value = "",
        onValueChange = {},
        placeholder = "E.g: John",
        trailingIcon = Icons.Default.Edit
    )
}

@Composable
fun PetRegister(navController: NavController){
    val imageUrl1 = {"https://i.ibb.co/Lpsfc5p/patitas.png"}
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var petcolor by remember { mutableStateOf("") }
    var petweight by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var specie by remember { mutableStateOf("") }

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
                    .clickable {  }
            )

        }
    }

    val fields = listOf(
        Triple("Name", name, Icons.Outlined.Pets),
        Triple("Age", age, null),
        Triple("Color", petcolor, Icons.Outlined.ColorLens),
        Triple("Weight", petweight, Icons.Outlined.MonitorWeight),
        Triple("Birth", dateOfBirth, Icons.Outlined.CalendarMonth),
        Triple("Gender", sex, Icons.Outlined.Pets),
        Triple("Breed", breed, Icons.Outlined.Pets),
        Triple("Specie", specie, Icons.Outlined.Pets),
        Triple("Description", description, Icons.Outlined.Description)
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
                            onValueChange = { /* handle value change */ },
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
                            onValueChange = { /* handle value change */ },
                            placeholder = " ", //"E.g: $label",
                            trailingIcon = icon
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }

        }
        Column(
            modifier = Modifier.fillMaxWidth(1f).offset(y= 320.dp).padding(10.dp)
        ) {
            val fieldIndex = 8
            if (fieldIndex < fields.size) {
                val (label, value, icon) = fields[fieldIndex]
                LabeledOutlinedTextField(
                    label = label,
                    value = value,
                    onValueChange = { /* handle value change */ },
                    placeholder = " ",
                    trailingIcon = icon
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
    Button(
        onClick = {
            //logic
        },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .offset(x=20.dp, y=600.dp)

    ) {
        Text("Add Pet")
    }

}


