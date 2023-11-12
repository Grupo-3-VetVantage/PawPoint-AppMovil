package upc.edu.pawpointapp.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import upc.edu.pawpointapp.data.model.Pet.PetRegister

interface PetService {
    @POST("api/Pet")
    suspend fun registerPet (@Body petRegister: PetRegister): Response<Void>
}