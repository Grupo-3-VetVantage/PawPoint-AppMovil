package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import upc.edu.pawpointapp.data.model.UserLogin
import upc.edu.pawpointapp.data.model.UserLoginResponse
import upc.edu.pawpointapp.data.model.UserRequest
import upc.edu.pawpointapp.data.model.UserResponse

interface UserService {
    @POST("api/User/SignUp")
    fun register(@Body userRequest: UserRequest): Call<UserResponse>

    @POST("api/User/Login")
    fun login (@Body userLogin: UserLogin): Call<UserLoginResponse>
}