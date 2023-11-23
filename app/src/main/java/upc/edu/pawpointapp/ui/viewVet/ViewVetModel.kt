package upc.edu.pawpointapp.ui.viewVet

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import upc.edu.pawpointapp.data.model.vet.VetResponse
import upc.edu.pawpointapp.repository.VetRepository
import upc.edu.pawpointapp.utils.Result

class ViewVetModel(val vetRepository: VetRepository = VetRepository()): ViewModel() {
    private val _vetList = MutableStateFlow<List<VetResponse>>(emptyList())
    val vetList: StateFlow<List<VetResponse>> get() = _vetList
    private val _vetId = MutableStateFlow<Int>(0)
    val vetId: StateFlow<Int> get() = _vetId
    private val _vet = MutableStateFlow<VetResponse?>(null)
    val vet: StateFlow<VetResponse?> get() = _vet

    fun getVetList(onVetResult: (Boolean) -> Unit){
        vetRepository.searchVets { result->
            when(result){
                is Result.Success->{
                    _vetList.value = result.data ?: throw IllegalArgumentException("list vets is null")
                    Log.e("vetId", "is correct ")
                    onVetResult(true)
                }
                is Result.Error->{
                    onVetResult(false)
                }
            }
        }
    }
}