package cl.desafiolatam.avesapp.sessionlista.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.aves.sessionlista.domain.ObtenerAveUseCase
import cl.desafiolatam.aves.sessionlista.domain.model.Aves
import kotlinx.coroutines.launch

class AvesViewModel(
    private val obtenerAveUseCase: ObtenerAveUseCase
) : ViewModel(){

    private val liveData = MutableLiveData<AvesUiState>()

    fun getLivaData() = liveData



     fun obtenerAves(){
        liveData.postValue(AvesUiState.LoadingAvesState)
        viewModelScope.launch {
            try {
                val response = obtenerAveUseCase.excecute()
                handlerResponse(response)
            } catch (exception: Exception){
                liveData.postValue(AvesUiState.ErrorServerAvesState)
            }

        }
    }

    private fun handlerResponse(response: Aves) {
            response.result.let{
                if (it.isNotEmpty()){
                    liveData.postValue(AvesUiState.SuccessAvesState(response))
                }else{
                    liveData.postValue(AvesUiState.EmptyListAvesState)
                }
            }

    }
}


