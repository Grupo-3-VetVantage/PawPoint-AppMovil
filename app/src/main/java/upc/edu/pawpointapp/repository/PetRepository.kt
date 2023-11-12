package upc.edu.pawpointapp.repository

import android.util.Log
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.data.remote.ApiClient
import upc.edu.pawpointapp.data.remote.PetService
import upc.edu.pawpointapp.utils.Result

class PetRepository(val petService: PetService = ApiClient.getPetService()) {
    suspend fun register(petRegister: PetRegister, callback: (Result<Unit>)-> Unit) {
        try {
            val response = petService.registerPet(petRegister)

            if (response.isSuccessful) {
                Log.d("PetRepository", "Pet registration successful")
                callback(Result.Success(Unit))
            } else {
                val errorBody = response.errorBody()?.string() ?: "Unknown error"
                callback(Result.Error("Registration failed: $errorBody"))
            }
        } catch (t: Throwable) {
            val message = t.message ?: "Unknown error"
            callback(Result.Error(message))
        }
    }
}
