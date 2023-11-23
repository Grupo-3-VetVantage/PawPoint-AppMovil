package upc.edu.pawpointapp.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.data.model.vet.VetResponse
import upc.edu.pawpointapp.data.remote.ApiClient
import upc.edu.pawpointapp.data.remote.VetService
import upc.edu.pawpointapp.utils.Result

class VetRepository(val vetService: VetService = ApiClient.getVetService()) {
    fun searchVets(callback: (Result<List<VetResponse>>)->Unit){
        val search = vetService.getAllVets()
        search.enqueue(object: Callback<List<VetResponse>> {
            override fun onResponse(call: Call<List<VetResponse>>, response: Response<List<VetResponse>>) {
                if (response.isSuccessful){
                    Log.e("Vets", "Vet message: ${response.body()}")
                    callback(Result.Success(response.body()!!))
                }
            }
            override fun onFailure(call: Call<List<VetResponse>>, t: Throwable) {
                callback(Result.Error(t.localizedMessage as String))
            }
        })
    }
}