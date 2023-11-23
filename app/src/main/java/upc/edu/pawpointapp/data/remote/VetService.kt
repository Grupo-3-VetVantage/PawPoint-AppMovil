package upc.edu.pawpointapp.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import upc.edu.pawpointapp.data.model.vet.VetResponse

interface VetService {
    @GET("Veterinary")
    fun getAllVets(): Call<List<VetResponse>>

    @GET("Veterinary/{id}")
    fun getVetById(@Path("id") id: Int): Call<VetResponse>
}