package upc.edu.pawpointapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://vetvantageapp.azurewebsites.net/"

    private var userService: UserService? = null
    private var petService: PetService? = null

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

    fun getPetService(): PetService{
        if(petService == null){
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            petService = retrofit.create(PetService::class.java)
        }
        return petService as PetService
    }
}