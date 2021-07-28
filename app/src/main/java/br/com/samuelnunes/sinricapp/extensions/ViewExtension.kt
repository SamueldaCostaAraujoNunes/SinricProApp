package br.com.samuelnunes.sinricapp.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 03/07/2021 at 02:04
 */

@BindingAdapter("visibleIf")
fun View.visibleIf(condicao: Boolean) {
    visibility = if (condicao) VISIBLE else GONE
}

suspend fun View.showWhile(func: suspend () -> Any) {
    visibility = VISIBLE
    func()
    visibility = GONE
}