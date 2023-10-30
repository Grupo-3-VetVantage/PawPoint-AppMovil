package upc.edu.pawpointapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://vetvantageapp.azurewebsites.net/api/"

    private var userService: UserService? = null

    fun getUserService(): UserService {
        if (userService == null) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            userService = retrofit.create(UserService::class.java)
        }
        return userService as UserService
    }
}