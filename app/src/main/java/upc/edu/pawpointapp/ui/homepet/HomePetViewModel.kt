package upc.edu.pawpointapp.ui.homepet

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import upc.edu.pawpointapp.data.model.pet.Pet
import upc.edu.pawpointapp.repository.UserRepository
import upc.edu.pawpointapp.utils.Result

class HomePetViewModel (val userRepository: UserRepository = UserRepository()): ViewModel() {
    private val _petList = MutableStateFlow<List<Pet>>(emptyList())
    val petList: StateFlow<List<Pet>> get() = _petList
    private val _petId = MutableStateFlow<Int>(0)
    val petId: StateFlow<Int> get() = _petId


    fun getPetLIst(id: Int, onPetResult: (Boolean) -> Unit){
        userRepository.searchPetsByUserId(id){result->
            when(result){
                is Result.Success->{
                    _petList.value = result.data ?: throw IllegalArgumentException("list pets is null")
                    Log.e("petId", "is correct ")
                    onPetResult(true)
                }
                is Result.Error->{
                    onPetResult(false)
                }
            }
        }
    }
}