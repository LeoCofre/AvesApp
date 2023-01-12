package cl.desafiolatam.avesapp.detalle.data.remote


import cl.desafiolatam.avesapp.detalle.domain.DetalleAveRepository
import cl.desafiolatam.avesapp.detalle.domain.model.DetalleAve


class RemoteDetalleAveRepository(
    private val detalleAveApi: DetalleAveApi,
    private val detalleAveMapper: DetalleAveMapper
) : DetalleAveRepository {


    override suspend fun obtenerDetalle(uid: String): DetalleAve {
        return detalleAveMapper.mapToEntity(detalleAveApi.getDetalleAveApi(uid))

    }
}