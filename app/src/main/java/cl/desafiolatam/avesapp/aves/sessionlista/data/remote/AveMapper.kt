package cl.desafiolatam.avesapp.sessionlista.data.remote


import cl.desafiolatam.aves.sessionlista.domain.model.Ave


class AveMapper {

    fun mapToEntity(aveModel: AveModel) : Ave {
        aveModel.apply {
            return Ave(uid,name,images,links ,sort)
        }
    }
}