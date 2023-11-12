package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import upc.edu.pawpointapp.data.model.User.UserLogin
import upc.edu.pawpointapp.data.model.User.UserRegister
import upc.edu.pawpointapp.data.model.User.UserResponse

interface UserService {

    @POST("api/User/Login")
    fun login (@Body userLogin: UserLogin): Call<UserResponse>

    @POST("api/User/SignUp")
    fun register(@Body userRegister: UserRegister): Call<UserResponse>

}
