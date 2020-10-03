package cl.desafiolatam.aves.registro.domain

class RegistroUsuarioUseCase (private  val  registroUsuarioRepository: RegistroUsuarioRepository){

    suspend fun excecute (registroUsuario: RegistroUsuario) = registroUsuarioRepository.registro(registroUsuario)


}