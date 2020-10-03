package cl.desafiolatam.aves.registro.data.remote

import cl.desafiolatam.aves.registro.domain.RegistroUsuario
import cl.desafiolatam.aves.registro.domain.RegistroUsuarioRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class FirebaseRegistroUsuarioRepository (
    private val firebaseAuth: FirebaseAuth
): RegistroUsuarioRepository {


    override suspend fun registro(registroUsuario: RegistroUsuario): Boolean {
        val result = firebaseAuth
            .createUserWithEmailAndPassword(registroUsuario.email, registroUsuario.password)
            .await()
        val user = firebaseAuth.currentUser
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(registroUsuario.nombre)
            .build()
        user?.updateProfile(profileUpdates)?.await()
        return result.user?.email?.isNotEmpty() ?: false
    }
}