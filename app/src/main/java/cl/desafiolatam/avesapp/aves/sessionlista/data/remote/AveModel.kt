package cl.desafiolatam.avesapp.sessionlista.data.remote

import cl.desafiolatam.aves.sessionlista.domain.model.ImagesAves
import cl.desafiolatam.aves.sessionlista.domain.model.LinksAves
import cl.desafiolatam.aves.sessionlista.domain.model.NameAves

data class AveModel (
    val uid : String? = null,
    val name : NameAves? = null,
    val images : ImagesAves? = null,
    val links : LinksAves? = null,
    val  sort : Int? = null
)