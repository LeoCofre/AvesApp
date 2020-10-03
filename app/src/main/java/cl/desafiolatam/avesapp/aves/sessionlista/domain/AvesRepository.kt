package cl.desafiolatam.aves.sessionlista.domain

import cl.desafiolatam.aves.sessionlista.domain.model.Aves
import io.reactivex.Single


interface AvesRepository  {
    suspend fun obtenerAves() : Aves
   // suspend fun  filtrarPorTexto(texto: String): Aves
}