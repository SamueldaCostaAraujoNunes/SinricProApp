package br.com.samuelnunes.sinricapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 11:45
 */
class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build()
        return chain.proceed(request)
    }
}