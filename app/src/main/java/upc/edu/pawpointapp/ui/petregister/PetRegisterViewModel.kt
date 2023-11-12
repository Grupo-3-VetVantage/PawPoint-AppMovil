package upc.edu.pawpointapp.ui.petregister

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import upc.edu.pawpointapp.data.model.Pet.PetRegister
import upc.edu.pawpointapp.repository.PetRepository
import upc.edu.pawpointapp.utils.Result

class PetRegisterViewModel(val petRepository: PetRepository = PetRepository()): ViewModel() {

    private  val _petRegisterResult = MutableLiveData<Boolean>()
    val petRegisterResult: LiveData<Boolean> get() = _petRegisterResult

    fun register(petRegister: PetRegister, onRegisterResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                petRepository.register(petRegister) { result ->
                    when (result) {
                        is Result.Success -> {
                            _petRegisterResult.value = true
                            onRegisterResult(true)
                        }
                        is Result.Error -> {
                            _petRegisterResult.value = false
                            onRegisterResult(false)
                        }
                    }
                }
            } catch (e: Exception) {
                _petRegisterResult.value = false
                onRegisterResult(false)
            }
        }
    }

}