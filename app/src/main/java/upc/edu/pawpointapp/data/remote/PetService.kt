package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.data.model.pet.PetResponse

interface PetService {
    @POST("Pet")
    suspend fun registerPet (@Body petRegister: PetRegister): Response<Void>
    @GET("Pet")
    fun getAllPets(): Call<PetResponse>

    @GET("Pet/{id}")
    fun getPetById(@Path("id") id: Int): Call<Pet>
}