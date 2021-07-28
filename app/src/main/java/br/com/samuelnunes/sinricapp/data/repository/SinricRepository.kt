package br.com.samuelnunes.sinricapp.data.repository

import br.com.samuelnunes.sinricapp.data.DTO.LoginDTO
import br.com.samuelnunes.sinricapp.data.entities.Auth
import br.com.samuelnunes.sinricapp.data.local.AppDatabase
import br.com.samuelnunes.sinricapp.data.remote.SinricService
import br.com.samuelnunes.sinricapp.extensions.toBase64
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 11:17
 */
class SinricRepository @Inject constructor(
    private val database: AppDatabase,
    private val sinricService: SinricService
) {
    private val authDao = database.authDAO()

    suspend fun login(userLogin: LoginDTO): Response<Auth>? {
        val concatenate = userLogin.email + ':' + userLogin.password
        val encoded = "Basic ${concatenate.toBase64()}"
        val login = safeRequest { sinricService.login(encoded) }
        login?.body()?.let { authDao.setAuth(it) }
        return login
    }


    private suspend fun <T> safeRequest(func: suspend () -> T?): T? {
        return try {
            func()
        } catch (e: HttpException) {
            Timber.e(e)
            null
        } catch (e: IOException) {
            Timber.e(e)
            null
        }
    }
}