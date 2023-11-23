package upc.edu.pawpointapp.ui.UserProfile

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.pawpointapp.ui.home.HomeViewModel


@Composable
fun UserProfile(navController: NavController,homeViewModel: HomeViewModel) {
    val userId by homeViewModel.userId.collectAsState()
    val userDetail by homeViewModel.user.collectAsState()

    LaunchedEffect(userId){
        if(userId!=null){
            homeViewModel.getUserDataById(userId)
            Log.d("UserProfile", "corroborar userId: ${userId}")
        }
    }
    if (userDetail!=null){
        Log.d("UserProfile", "user: $userDetail")
        Log.d("UserProfile", "user?.imgUrl: ${userDetail?.imgUrl}")

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "User Profile")
                }
            }
            UserProfileCard(homeViewModel)
        }
    }
}

@Composable
fun UserProfileCard(homeViewModel: HomeViewModel){

    val userDetail by homeViewModel.user.collectAsState()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            GlideImage(
                imageModel = {"https://cdn.discordapp.com/attachments/1154594922339516427/1177239823317225563/ai-image-generation-fake-faces-people-nvidia-5c18b20b472c2__700.jpg?ex=6571c905&is=655f5405&hm=cdcc21cc99516fe04bed1253049f006047d699dffa87a327229ec15e2d638b34&"},

                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                loading = {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Loading")
                        }
                    }
                },
                failure = {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Failure")
                        }
                    }
                }
            )
            Text(
                text = userDetail!!.firstName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = userDetail!!.email,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = userDetail!!.userName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = userDetail!!.lastName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = userDetail!!.phone,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = userDetail!!.address,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

        }
    }
}


