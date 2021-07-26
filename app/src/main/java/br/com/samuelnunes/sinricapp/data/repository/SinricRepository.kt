package br.com.samuelnunes.sinricapp.data.repository

import br.com.samuelnunes.sinricapp.data.DTO.LoginDTO
import br.com.samuelnunes.sinricapp.data.entities.Auth
import br.com.samuelnunes.sinricapp.data.remote.SinricService
import br.com.samuelnunes.sinricapp.extensions.toBase64
import javax.inject.Inject

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 11:17
 */
class SinricRepository @Inject constructor(
    private val sinricService: SinricService
) {
    suspend fun login(userLogin: LoginDTO): Auth {
        val concatenate = userLogin.email + ':' + userLogin.password
        val encoded = "Basic ${concatenate.toBase64()}"
        return sinricService.login(encoded)
    }
}