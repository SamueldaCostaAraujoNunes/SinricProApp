package br.com.samuelnunes.sinricapp.extensions

import br.com.samuelnunes.sinricapp.util.Watcher
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 27/07/2021 at 09:50
 */

fun TextInputLayout.defineError(messageError: String?) {
    isErrorEnabled = if (messageError.isNullOrEmpty()) {
        false
    } else {
        error = messageError
        true
    }
}

@FlowPreview
@ExperimentalCoroutinesApi
suspend fun TextInputLayout.afterTextChanged(afterTextChanged: suspend (String) -> Unit) {
    Watcher().also { watcher ->
        editText!!.addTextChangedListener(watcher)
        watcher.asFlow()
            .debounce(1000)
            .collect { text ->
                afterTextChanged(text)
            }
    }

}