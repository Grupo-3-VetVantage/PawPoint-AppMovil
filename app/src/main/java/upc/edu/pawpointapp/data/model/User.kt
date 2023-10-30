package upc.edu.pawpointapp.data.model

data class User(
    val userName: String?,
    val password: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String?,
    val address: String?,
    val created_at: String,
    val id: Int,
    val updated_at: String
)