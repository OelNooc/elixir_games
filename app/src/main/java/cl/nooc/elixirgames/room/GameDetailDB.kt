package cl.nooc.elixirgames.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.nooc.elixirgames.dao.GamesDetailDao
import cl.nooc.elixirgames.modelo.GameDetail

//crear sólo una base de datos con ambas tablas!!
@Database(entities = [GameDetail::class], version = 1)
abstract class GameDetailDB: RoomDatabase() {

    abstract fun gameDetailDao(): GamesDetailDao

    companion object{
        @Volatile
        private var instancia:GameDetailDB? = null

        fun getInstancia (context: Context): GameDetailDB{
            if(instancia == null){
                synchronized(this){
                    instancia = Room.databaseBuilder(context,
                        GameDetailDB::class.java, "gameDetail_db").build()
                }
            }
            return instancia!!
        }
    }
}