package cl.desafiolatam.aves.login.data.remote

import cl.desafiolatam.aves.login.domain.LoginUsuario
import cl.desafiolatam.aves.login.domain.LoginUsuarioRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirebaseLoginUsuarioRepository(
    private val firebaseAuth: FirebaseAuth
) : LoginUsuarioRepository {


    override suspend fun doLogin(email: String, clave: String): LoginUsuario {
        firebaseAuth
            .signInWithEmailAndPassword(email, clave)
            .await()
        val user = firebaseAuth.currentUser
        return LoginUsuario(user?.displayName ?: "", user?.email ?: "")

    }
}