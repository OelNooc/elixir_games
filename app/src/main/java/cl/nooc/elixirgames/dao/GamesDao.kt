package cl.nooc.elixirgames.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.nooc.elixirgames.modelo.Games
import cl.nooc.elixirgames.modelo.GamesItem

@Dao
interface GamesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(games: Games)

    @Query("select Id, Name, bc_image," +
            "metacritic, rating, released from Games")
    fun listar(): LiveData<Games>

    @Query("select Id, Name, bc_image," +
        "metacritic, rating, released from Games where id = :id")
    fun buscar(id:String) : GamesItem

    @Query("select count(*) from Games")
    fun contar(): Int

}