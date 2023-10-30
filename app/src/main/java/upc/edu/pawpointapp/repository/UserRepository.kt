package upc.edu.pawpointapp.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.pawpointapp.data.model.UserRequest
import upc.edu.pawpointapp.data.model.UserResponse
import upc.edu.pawpointapp.data.remote.ApiClient
import upc.edu.pawpointapp.data.remote.UserService
import upc.edu.pawpointapp.data.utils.Result

class UserRepository(val userService: UserService = ApiClient.getUserService()) {

    fun register(userRequest: UserRequest, callback: (Result<UserResponse>) -> Unit) {
        val register = userService.register(userRequest)

        register.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()!!
                    callback(Result.Success(userResponse))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message!!
                callback(Result.Error(message))
            }

        })
    }
}