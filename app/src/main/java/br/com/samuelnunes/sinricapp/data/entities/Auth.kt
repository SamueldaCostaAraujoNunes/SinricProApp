package br.com.samuelnunes.sinricapp.data.entities

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 12:00
 */
data class Auth(
    val success: Boolean,
    val message: String,
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int,
    val subscriptionExpired: Boolean,
    val account: Account
)