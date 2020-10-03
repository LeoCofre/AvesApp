package cl.desafiolatam.aves.login.domain

class LoginUsuarioUseCase(
    private val repository: LoginUsuarioRepository
) {

suspend fun excecute (email:String, clave :String) = repository.doLogin(email,clave)
}