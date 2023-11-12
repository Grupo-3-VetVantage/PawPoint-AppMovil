package upc.edu.pawpointapp.data.model.pet

data class Pet(
    val id: Int,
    val name: String,
    val age: Int,
    val color: String,
    val weight: Int,
    val dateOfBirth: String,
    val description: String,
    val imgUrl: String,
    val sex: String,
    val breed: String,
    val specie: String,
    val ownerId: Int
)