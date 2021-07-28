package br.com.samuelnunes.sinricapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.samuelnunes.sinricapp.data.entities.Account
import br.com.samuelnunes.sinricapp.data.entities.Auth
import br.com.samuelnunes.sinricapp.data.local.dao.AuthDAO

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 18:05
 */
@Database(entities = [Auth::class, Account::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun authDAO(): AuthDAO
}