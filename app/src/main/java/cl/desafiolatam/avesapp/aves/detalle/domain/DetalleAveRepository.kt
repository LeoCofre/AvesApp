package cl.desafiolatam.avesapp.detalle.domain


import cl.desafiolatam.avesapp.detalle.domain.model.DetalleAve


interface DetalleAveRepository {
    suspend fun obtenerDetalle(uid : String): DetalleAve
}