package upc.edu.pawpointapp.data.model.user

data class UserResponse(
    val id: Int,
    val userName: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val roles: String,
    val password: String,
    val phone: String,
    val address: String,
    val imgUrl: String,
)
