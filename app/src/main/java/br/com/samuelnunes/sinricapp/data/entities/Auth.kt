package br.com.samuelnunes.sinricapp.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 12:00
 */

@Entity
data class Auth(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val success: Boolean,
    val message: String,
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int,
    val subscriptionExpired: Boolean,
    @Embedded val account: Account,
)