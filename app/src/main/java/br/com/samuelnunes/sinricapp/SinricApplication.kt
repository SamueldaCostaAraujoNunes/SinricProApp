package br.com.samuelnunes.sinricapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 25/07/2021 at 22:54
 */
@HiltAndroidApp
class SinricApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}