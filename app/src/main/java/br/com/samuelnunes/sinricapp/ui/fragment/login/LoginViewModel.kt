package br.com.samuelnunes.sinricapp.ui.fragment.login

import androidx.lifecycle.ViewModel
import br.com.samuelnunes.sinricapp.data.DTO.LoginDTO
import br.com.samuelnunes.sinricapp.data.repository.SinricRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 11:09
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: SinricRepository) : ViewModel() {

    suspend fun login(loginDTO: LoginDTO) = repository.login(loginDTO)
}