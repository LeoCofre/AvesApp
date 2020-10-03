package cl.desafiolatam.avesapp.detalle.data.remote


import cl.desafiolatam.avesapp.detalle.domain.model.DetalleAve


class DetalleAveMapper {

    fun mapToEntity (detalleAveModel: DetalleAveModel): DetalleAve {
     detalleAveModel.apply{
         return DetalleAve(uid, name, map, iucn,habitat,didyouknow,
             size,species,audio,images)
         }    
    }      
}