package cl.desafiolatam.aves.sessionlista.data.remote


import cl.desafiolatam.avesapp.sessionlista.data.remote.AveModel
import retrofit2.http.GET

interface AvesApi {
    @GET("birds")
suspend fun getAveApi() : List<AveModel>
}