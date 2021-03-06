package cl.desafiolatam.aves.registro.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.desafiolatam.avesapp.R

import cl.desafiolatam.aves.registro.data.remote.FirebaseRegistroUsuarioRepository
import cl.desafiolatam.aves.registro.domain.RegistroUsuario
import cl.desafiolatam.aves.registro.domain.RegistroUsuarioUseCase
import cl.desafiolatam.aves.utils.extension.*
import cl.desafiolatam.avesapp.databinding.FragmentRegistroUsuarioBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroUsuarioFragment : Fragment(R.layout.fragment_registro_usuario) {

    lateinit var binding: FragmentRegistroUsuarioBinding
    lateinit var viewModel: RegistroUsuarioViewModel
    lateinit var viewModelFactory: RegistroUsuarioViewModelFactory


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependecies()
        binding = FragmentRegistroUsuarioBinding.bind(view)
        setupLiveData()
        setupListener()
    }

    private fun setupDependecies() {
        viewModelFactory = RegistroUsuarioViewModelFactory(
            RegistroUsuarioUseCase(
                FirebaseRegistroUsuarioRepository(FirebaseAuth.getInstance())
            )
        )
        viewModel = ViewModelProvider(
            this,viewModelFactory).get(RegistroUsuarioViewModel::class.java)

    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { state ->
                state?.let { handleState(it) }
            }
        )
    }

    private fun handleState(state: RegistroUsuarioUiState) {
        when(state){
            is RegistroUsuarioUiState.LoadingRegistroUsuarioUiState -> showLoading()
            is RegistroUsuarioUiState.SuccessRegistroUiState -> showSuccess()
            is RegistroUsuarioUiState.InvalidEmailRegistroUiState -> showInvalid()
            is RegistroUsuarioUiState.ErrorRegistroUiState -> showError()
        }
    }

    private fun showLoading() {
        alert("Cargando ......")
    }

    private fun showSuccess() {
        alert("Registro Exitoso")
    }

    private fun showInvalid() {
        alert("Email Invalido")
    }

    private fun showError() {
        alert("Lo sentimos ha ocurrido un error")
    }

    private fun setupListener() {
        binding.apply {
             btnRegistrar.setOnClickListener {
                if (isAllValidinput()){
                    viewModel.registrarUsuario(obtenerValoresEditText())
                }
            }
            btnVolver.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun isAllValidinput(): Boolean {
        binding.apply {
            return etPass.isValidPassInput("ingresar contraseña con minimo 6 caracteres")||
            return etEmail.isValidEmailInput("ingresar e-mail válido")||
            return etTelefono.isValidTelefonoInput("ingresar un número de telefono celular válido")||
            return etRut.isValidRutInput("ingresar rut válido sin puntos y con guión")||
            return etNombre.isValidNameInput("ingresar nombre y apellido válido")
        }
    }

    private fun obtenerValoresEditText(): RegistroUsuario {
        binding.apply {
            return RegistroUsuario(
                etNombre.text.toString(),
                etRut.text.toString(),
                etEmail.text.toString(),
                etPass.text.toString(),
                etTelefono.text.toString()

            )
        }
    }


}