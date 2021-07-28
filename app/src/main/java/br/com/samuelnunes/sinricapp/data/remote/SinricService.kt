package br.com.samuelnunes.sinricapp.data.remote

import br.com.samuelnunes.sinricapp.data.entities.Auth
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface SinricService {

    @FormUrlEncoded
    @POST("auth")
    suspend fun login(
        @Header("Authorization") auth: String,
        @Field("client_id") client_id: String = "android-app"
    ): Response<Auth>
}
