package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.data.model.Pet.PetResponse

interface PetService {
    @POST("api/Pet")
    fun registerPet (@Body petRegister: PetRegister): Call<PetResponse>
}