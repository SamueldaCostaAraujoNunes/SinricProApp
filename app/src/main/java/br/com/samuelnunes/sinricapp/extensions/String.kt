package br.com.samuelnunes.sinricapp.extensions

import java.util.Base64.getEncoder

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 12:55
 */

fun String.toBase64(): String = getEncoder().encodeToString(toByteArray())