package br.com.samuelnunes.sinricapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import br.com.samuelnunes.sinricapp.data.entities.Auth

/**
 * @author Samuel da Costa Araujo Nunes
 * Created 26/07/2021 at 18:29
 */

@Dao
interface AuthDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setAuth(auth: Auth)
}