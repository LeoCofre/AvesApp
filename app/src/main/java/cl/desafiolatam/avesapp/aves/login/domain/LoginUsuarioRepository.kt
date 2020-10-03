package cl.desafiolatam.aves.login.domain

interface LoginUsuarioRepository {

    suspend fun doLogin(email : String, clave : String) : LoginUsuario
}