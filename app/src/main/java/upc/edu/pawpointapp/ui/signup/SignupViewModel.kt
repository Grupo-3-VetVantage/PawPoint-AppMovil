package upc.edu.pawpointapp.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import upc.edu.pawpointapp.data.model.User.UserRegister
import upc.edu.pawpointapp.data.model.User.UserResponse
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.utils.Result

class SignUpViewModel(private val userRepository: UserRepository = UserRepository()) : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> get() = _firstName

    private val _registrationResult = MutableLiveData<Result<UserResponse>>()
    val registrationResult: LiveData<Result<UserResponse>> get() = _registrationResult

    fun updateUsername(username: String) {
        _username.value = username
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updateFirstName(firstName: String) {
        _firstName.value = firstName
    }

    fun register() {
        val userRequest = UserRegister(username.value ?: "", password.value ?: "", firstName.value ?: "", email.value ?: "")
        userRepository.register(userRequest) { result ->
            _registrationResult.value = result
        }
    }

    override fun onCleared() {
        // Realiza cualquier limpieza necesaria cuando el ViewModel se destruye
        // Por ejemplo, cancela solicitudes de red o libera recursos.
        super.onCleared()
    }
}
