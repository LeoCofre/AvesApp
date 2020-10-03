package cl.desafiolatam.avesapp.login.presentation


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cl.desafiolatam.aves.login.data.remote.FirebaseLoginUsuarioRepository
import cl.desafiolatam.aves.login.domain.LoginUsuarioRepository
import cl.desafiolatam.aves.login.domain.LoginUsuarioUseCase
import cl.desafiolatam.aves.login.presentation.LoginUsuarioUiState
import cl.desafiolatam.aves.login.presentation.LoginUsuarioViewModel
import cl.desafiolatam.aves.login.presentation.LoginUsuarioViewModelFactory
import cl.desafiolatam.aves.utils.extension.alert
import cl.desafiolatam.avesapp.R
import cl.desafiolatam.avesapp.databinding.FragmentLoginUsuarioBinding
import com.google.firebase.auth.FirebaseAuth

class LoginUsuarioFragment : Fragment(R.layout.fragment_login_usuario) {

    private lateinit var binding: FragmentLoginUsuarioBinding
    private lateinit var repository: LoginUsuarioRepository
    private lateinit var viewModel: LoginUsuarioViewModel
    private lateinit var viewModelFactory: LoginUsuarioViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentLoginUsuarioBinding.bind(view)
        setupLiveData()
        setupListener()

    }

    private fun setupDependencies() {
        repository = FirebaseLoginUsuarioRepository(FirebaseAuth.getInstance())
        viewModelFactory = LoginUsuarioViewModelFactory(LoginUsuarioUseCase(repository))
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(LoginUsuarioViewModel::class.java)

    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { state -> state?.let { handleState(it) } }
        )


    }

    private fun handleState(state: LoginUsuarioUiState) {
        when (state) {
            is LoginUsuarioUiState.Loading -> showLoading()
            is LoginUsuarioUiState.Success -> showSuccess()
            is LoginUsuarioUiState.InvalidUser -> showInvalid()
            is LoginUsuarioUiState.Error -> showError()

        }

    }

    private fun showLoading() {
        alert("Cargando.....")
    }

    private fun showSuccess() {
        alert("Login exitoso")
    }

    private fun showInvalid() {
        alert("Usuario invalido")
    }

    private fun showError() {
        alert("Ha ocurrido un error")

    }

    private fun setupListener() {
        binding.apply {
            btnLogin.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_loginUsuarioFragment_to_splashFragment)
            }
            btnRegistro.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_loginUsuarioFragment_to_registroUsuarioFragment2)
            }
        }

    }

}