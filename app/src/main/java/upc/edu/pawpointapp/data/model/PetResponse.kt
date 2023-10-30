package upc.edu.pawpointapp.data.model

import com.google.gson.annotations.SerializedName

data class Pet (
    val id: Int,
    val name: String,
    val age: Int,
    val petColor: String,
    val petWeight: Int,
    val dateOfBirth: String,
    val description: String,
    val imageUrl: String,
    val sex: String,
    val breed: String,
    val specie: String,
)

data class PetResponse(
    @SerializedName("results")
    val pets: List<Pet>
)