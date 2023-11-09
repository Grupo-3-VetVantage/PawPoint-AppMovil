package upc.edu.pawpointapp.data.model

data class UserLoginResponse (
    val id: Int,
    val userName: String,
    val password: String,
    val roles: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val address: String,
    val isVet: Boolean,
    val imgUrl: String,
    val isActive: Boolean,
)