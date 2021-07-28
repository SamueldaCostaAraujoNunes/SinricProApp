package br.com.samuelnunes.sinricapp.util

import android.text.Editable
import android.text.TextWatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 27/07/2021 at 10:48
 */

@ExperimentalCoroutinesApi
class Watcher : TextWatcher {

    private val channel = ConflatedBroadcastChannel<String>()

    override fun afterTextChanged(editable: Editable?) {
        channel.offer(editable.toString())
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

    @FlowPreview
    fun asFlow(): Flow<String> {
        return channel.asFlow()
    }
}