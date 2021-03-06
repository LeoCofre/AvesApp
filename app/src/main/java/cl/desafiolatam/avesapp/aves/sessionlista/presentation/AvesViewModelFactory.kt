package cl.desafiolatam.avesapp.sessionlista.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.desafiolatam.aves.sessionlista.domain.ObtenerAveUseCase

class AvesViewModelFactory (
    private val aveUseCase : ObtenerAveUseCase
) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerAveUseCase::class.java)
            .newInstance(aveUseCase)
    }


}