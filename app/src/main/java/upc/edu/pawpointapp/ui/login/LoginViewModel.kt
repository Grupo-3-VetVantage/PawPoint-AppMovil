package upc.edu.pawpointapp.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import upc.edu.pawpointapp.data.model.User.UserLogin
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.utils.Result

class LoginViewModel(val userRepository: UserRepository = UserRepository()): ViewModel() {
    private  var logged: Int? = null

    fun setLogged(userId: Int){
        logged = userId
    }
    fun getLogged():Int{
        return logged?: throw IllegalAccessException("User is not logged in$logged")

    }
    fun isLogged():Boolean{
        return logged!=null
    }
    fun login(userLogin: UserLogin, onLoginResult: (Boolean) -> Unit) {
        userRepository.login(userLogin){ result ->
            when(result){
                is Result.Success->{
                    val userId = result.data?.id ?: throw IllegalArgumentException("User ID is null")
                    setLogged(userId)
                    onLoginResult(true)
                }
                is Result.Error->{
                    onLoginResult(false)
                }
            }

        }
    }
}