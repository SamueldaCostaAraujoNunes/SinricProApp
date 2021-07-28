package br.com.samuelnunes.sinricapp.extensions

import android.text.TextUtils
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import java.util.Base64.getEncoder

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 12:55
 */

fun String.toBase64(): String = getEncoder().encodeToString(toByteArray())

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && EMAIL_ADDRESS.matcher(this).matches()
}