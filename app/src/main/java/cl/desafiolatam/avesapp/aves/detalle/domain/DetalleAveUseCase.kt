package cl.desafiolatam.avesapp.detalle.domain

import cl.desafiolatam.avesapp.detalle.data.remote.RemoteDetalleAveRepository

class DetalleAveUseCase(
    private val repository: RemoteDetalleAveRepository
) {
    suspend fun excecute(uid : String) = repository.obtenerDetalle(uid )
}