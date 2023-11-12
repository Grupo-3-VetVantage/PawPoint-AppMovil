package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import upc.edu.pawpointapp.data.model.user.UserLogin
import upc.edu.pawpointapp.data.model.user.UserRegister
import upc.edu.pawpointapp.data.model.user.UserResponse

interface UserService {

    @POST("user/Login")
    fun login (@Body userLogin: UserLogin): Call<UserResponse>

    @POST("user/SignUp")
    fun register(@Body userRegister: UserRegister): Call<UserResponse>

}
