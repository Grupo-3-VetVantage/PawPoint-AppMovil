package upc.edu.pawpointapp.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import upc.edu.pawpointapp.data.model.User.UserLogin
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.utils.Result

class LoginViewModel(val userRepository: UserRepository = UserRepository()): ViewModel() {
    private val _logged = MutableStateFlow<Int?>(null)
    val logged: StateFlow<Int?> get() = _logged


    fun setLogged(userId: Int){
        _logged.value = userId
    }
    fun getLogged():Int{
        return _logged.value?: throw IllegalAccessException("User is not logged in$logged")

    }
    fun isLogged():Boolean{
        return _logged.value!=null
    }

    fun login(userLogin: UserLogin, onLoginResult: (Boolean) -> Unit) {
        userRepository.login(userLogin){ result ->
            when(result){
                is Result.Success->{
                    val userId = result.data?.id ?: throw IllegalArgumentException("User ID is null")
                    setLogged(userId)
                    Log.e("userId", "is correct ${getLogged()}")
                    isLogged()
                    onLoginResult(true)
                }
                is Result.Error->{
                    onLoginResult(false)
                }
            }

        }
    }
}