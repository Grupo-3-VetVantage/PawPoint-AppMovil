package upc.edu.pawpointapp.data.model.User

data class UserResponse(
    val Id: Int,
    val UserName: String,
    val Email: String,
    val FirstName: String,
    val LastName: String,
    val Roles: String,
    val Password: String,
    val Phone: String,
    val Address: String,
    val ImgUrl: String
)
