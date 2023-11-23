package upc.edu.pawpointapp.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import upc.edu.pawpointapp.data.model.user.UserResponse
import upc.edu.pawpointapp.repository.UserRepository

//UserProfileViewModel
class HomeViewModel(val userRepository: UserRepository = UserRepository()): ViewModel()  {
    private val _user = MutableStateFlow<UserResponse?>(null)
    val user: StateFlow<UserResponse?> get() = _user

    private val _userId = MutableStateFlow<Int>(0)
    val userId: StateFlow<Int> get() = _userId
    fun getUserDataById(id: Int){
        userRepository.searchUserById(id){result ->
            _user.value = result.data
        }
    }

    fun setUserId(id: Int){
        _userId.value = id
    }


}
