package cl.desafiolatam.aves.sessionlista.domain

class ObtenerAveUseCase(
    private val repository: AvesRepository
) {

    suspend fun excecute() = repository.obtenerAves()


}