package cl.desafiolatam.avesapp.sessionlista.data.remote

import cl.desafiolatam.aves.sessionlista.data.remote.AvesApi
import cl.desafiolatam.aves.sessionlista.domain.AvesRepository
import cl.desafiolatam.aves.sessionlista.domain.model.Aves

class RemoteAvesRepository(
    private val avesApi: AvesApi,
    private val aveMapper: AveMapper
) : AvesRepository {
    override suspend fun obtenerAves(): Aves {
        val aves  = avesApi.getAveApi()

        val listaTrasformada =
            aves.map { aveMapper.mapToEntity(it) } ?: emptyList()

        return Aves(listaTrasformada)
    }

  /*  override suspend fun filtrarPorTexto(texto: String): Aves {
        val listaFiltrada = .init().filter {
            it.comuna.contains(texto, true) || it.nombre.contains(texto, true)
        }
        return Single.just(listaFiltrada)

    }*/


}