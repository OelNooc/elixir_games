package cl.nooc.elixirgames.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.nooc.elixirgames.modelo.GameDetail

@Dao
interface GamesDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(gameDetail: GameDetail)

    @Query("select Id, Name, bc_img, genres, last_price, platforms, playtime, price," +
            "metacritic, rating, released, delivery, format from Games_Detail")
    fun listar(): LiveData<GameDetail>

    @Query("select Id, Name, bc_img, genres, last_price, platforms, playtime, price," +
            "metacritic, rating, released, delivery, format from Games_Detail")
    fun buscar(id:String) : GameDetail

    @Query("select count(*) from Games_Detail")
    fun contar(): Int
}