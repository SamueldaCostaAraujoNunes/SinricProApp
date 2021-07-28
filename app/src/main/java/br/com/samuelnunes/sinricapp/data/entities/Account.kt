package br.com.samuelnunes.sinricapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 15:46
 */

@Entity
data class Account(
    val temperatureScale: String,
    val language: String,
    val isGoogleHomeLinked: Boolean,
    val isAmazonAlexaLinked: Boolean,
    val isSinricProAppLinked: Boolean,
    val isSmartThingsLinked: Boolean,
    val isIFTTTLinked: Boolean,
    val isVerified: Boolean,
    val sendNewsLetters: Boolean,
    val name: String,
    val email: String,
    val timeZone: String,
    val isManufacturer: Boolean,
    val displayName: String,
    val country: String,
    val createdAt: String,
    val updatedAt: String,
    @PrimaryKey
    val id: String
)
