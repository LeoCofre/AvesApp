package cl.desafiolatam.avesapp.detalle.data.remote

import cl.desafiolatam.aves.sessionlista.domain.model.NameAves
import cl.desafiolatam.avesapp.detalle.domain.model.Audio
import cl.desafiolatam.avesapp.detalle.domain.model.ImagesDetalle
import cl.desafiolatam.avesapp.detalle.domain.model.IucnAve
import cl.desafiolatam.avesapp.detalle.domain.model.MapAve

data class DetalleAveModel (
    val uid : String? = null,
    val name : NameAves? = null,
    val map : MapAve? = null,
    val iucn : IucnAve? = null,
    val habitat : String? = null,
    val didyouknow : String? = null,
    val size : String? = null,
    val species : String? = null,
    val audio : Audio? = null,
    val images : ImagesDetalle? = null
)