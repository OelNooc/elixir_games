package cl.nooc.elixirgames.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.nooc.elixirgames.dao.GamesDao
import cl.nooc.elixirgames.modelo.GamesItem

@Database(entities = [GamesItem::class], version = 1)
abstract class GamesDB: RoomDatabase() {

    abstract fun gamesDao(): GamesDao

    companion object{
        @Volatile
        private var instancia:GamesDB? = null

        fun getInstancia (context: Context): GamesDB{
            if(instancia == null){
                synchronized(this){
                    instancia = Room.databaseBuilder(context,
                        GamesDB::class.java, "games_db").build()
                }
            }
            return instancia!!
        }
    }
}