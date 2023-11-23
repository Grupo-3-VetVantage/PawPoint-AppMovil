package upc.edu.pawpointapp.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.data.model.pet.PetResponse
import upc.edu.pawpointapp.data.model.user.UserLogin
import upc.edu.pawpointapp.data.model.user.UserRegister
import upc.edu.pawpointapp.data.model.user.UserResponse
import upc.edu.pawpointapp.data.remote.ApiClient
import upc.edu.pawpointapp.data.remote.UserService
import upc.edu.pawpointapp.utils.Result

class UserRepository(val userService: UserService = ApiClient.getUserService()) {

    fun register(userRegister: UserRegister, callback: (Result<UserResponse>) -> Unit) {
        val register = userService.register(userRegister)

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
    //login
    fun login(userLogin: UserLogin, callback: (Result<UserResponse>) -> Unit){
        val login = userService.login(userLogin)

        login.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val userResponse = response.body()!!
                    if (userResponse != null) {
                        callback(Result.Success(userResponse))
                        Log.d("Login", "Response body: $userResponse")
                        Log.d("Login", "Id requerido: ${userResponse.id}")
                    } else {
                        callback(Result.Error("Login failed: Response body is null"))
                    }
                }else {
                    val errorBody = response.errorBody()?.string() ?: "Unknown error"
                    callback(Result.Error("Login failed: $errorBody"))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message ?: "Unknown error"
                Log.e("Login", "Login failed: $message")
                callback(Result.Error(message))
            }
        })
    }

    //pets
    fun searchPetsByUserId(id: Int, callback: (Result<List<Pet>>)->Unit){
        val searchById = userService.getPetsByUserId(id)
        searchById.enqueue(object: Callback<List<Pet>> {
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                if (response.isSuccessful){
                    val pets = response.body()!!
                    Log.e("Pets", "Pet message: ${response.body()}")
                    callback(Result.Success(pets))

                }
            }
            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                val message = t.message!!
                Log.e("Pets", "Pet message: $message")
                callback(Result.Error(message))
            }
        })
    }

    //getUserById
    fun searchUserById(id: Int, callback: (Result<UserResponse>) -> Unit){
        val searchUserById = userService.getUserById(id)
        searchUserById.enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val userResponse = response.body()!!
                    Log.e("User", "User message: ${response.body()}")
                    callback(Result.Success(userResponse))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message!!
                Log.e("User", "User message: $message")
                callback(Result.Error(message))
            }
        })

    }



}
