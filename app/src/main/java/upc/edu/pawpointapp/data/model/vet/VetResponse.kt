package upc.edu.pawpointapp.data.model.vet

data class VetResponse(
    val id: Int,
    val name: String,
    val lastName: String,
    val speciality: String,
    val phone: String,
    val address: String,
    val description: String,
    val imgUrl: String,
)