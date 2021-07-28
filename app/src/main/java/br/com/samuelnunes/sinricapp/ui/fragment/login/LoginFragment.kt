package br.com.samuelnunes.sinricapp.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.com.samuelnunes.sinricapp.data.DTO.LoginDTO
import br.com.samuelnunes.sinricapp.databinding.FragmentLoginBinding
import br.com.samuelnunes.sinricapp.extensions.afterTextChanged
import br.com.samuelnunes.sinricapp.extensions.defineError
import br.com.samuelnunes.sinricapp.extensions.showWhile
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 25/07/2021 at 23:01
 */

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginConfirm.setOnClickListener {
            lifecycleScope.launch {
                binding.progressBar.showWhile {
                    val login = viewModel.login(
                        LoginDTO(
                            binding.email.text.toString(),
                            binding.password.text.toString()
                        )
                    )
                    val code = login?.code() ?: 500
                    Snackbar.make(
                        view,
                        when (code) {
                            200 -> "Bem vindo ${login!!.body()!!.account.name}!!!"
                            403 -> "Usuario ou senha incorreto!!"
                            500 -> "Sem conexão com a Internet!"
                            else -> "Deu ruim"
                        },
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            binding.emailInputLayout.apply {
                afterTextChanged {
                    defineError(viewModel.validateEmail(it))
                }
            }
        }

    }
}