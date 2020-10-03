package cl.desafiolatam.aves.registro.domain

data class RegistroUsuario (
    val nombre : String,
    val rut : String,
    val telefono : String,
    val email : String,
    val  password : String
)