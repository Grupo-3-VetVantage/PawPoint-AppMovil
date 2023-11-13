package upc.edu.pawpointapp.data.model.pet

data class PetRegister (
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
    var ownerId: Int,
)