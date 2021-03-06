package br.com.samuelnunes.sinricapp.di

import android.content.Context
import androidx.room.Room
import br.com.samuelnunes.sinricapp.TABLE_NAME
import br.com.samuelnunes.sinricapp.data.local.AppDatabase
import br.com.samuelnunes.sinricapp.data.remote.MyInterceptor
import br.com.samuelnunes.sinricapp.data.remote.SinricService
import br.com.samuelnunes.sinricapp.data.repository.SinricRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 11:20
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerClient(): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.sinric.pro/api/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideCharacterService(retrofit: Retrofit): SinricService =
        retrofit.create(SinricService::class.java)

    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, TABLE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideSinricRepository(
        database: AppDatabase,
        sinricService: SinricService
    ): SinricRepository =
        SinricRepository(database, sinricService)


}