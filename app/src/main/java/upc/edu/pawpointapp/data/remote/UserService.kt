package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.data.model.user.UserLogin
import upc.edu.pawpointapp.data.model.user.UserRegister
import upc.edu.pawpointapp.data.model.user.UserResponse

interface UserService {

    @POST("user/Login")
    fun login (@Body userLogin: UserLogin): Call<UserResponse>

    @POST("user/SignUp")
    fun register(@Body userRegister: UserRegister): Call<UserResponse>

    @GET("user/GetPets/{id}")
    fun getPetsByUserId(@Path("id") id: Int): Call<List<Pet>>
}
