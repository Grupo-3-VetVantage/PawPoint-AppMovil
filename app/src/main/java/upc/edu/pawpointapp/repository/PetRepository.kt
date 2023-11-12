package upc.edu.pawpointapp.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.data.remote.ApiClient
import upc.edu.pawpointapp.data.remote.PetService
import upc.edu.pawpointapp.utils.Result

class PetRepository(
    private val petService: PetService = ApiClient.getPetService()
) {
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
    fun searchById(id: Int, callback: (Result<Pet>)->Unit){
        val searchById = petService.getPetById(id)
        searchById.enqueue(object: Callback<Pet> {
            override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
                if (response.isSuccessful){
                    callback(Result.Success(response.body()!!))
                }
            }
            override fun onFailure(call: Call<Pet>, t: Throwable) {
                callback(Result.Error(t.localizedMessage as String))
            }
        })
    }
}
