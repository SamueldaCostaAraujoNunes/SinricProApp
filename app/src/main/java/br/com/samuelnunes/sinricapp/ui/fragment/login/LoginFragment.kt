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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginConfirm.setOnClickListener {
            lifecycleScope.launch {
                val login = viewModel.login(
                    LoginDTO(
                        binding.email.text.toString(),
                        binding.password.text.toString()
                    )
                )
                Timber.d(login.account.name)
            }
        }
    }
}