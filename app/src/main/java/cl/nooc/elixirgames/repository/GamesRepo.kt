package cl.nooc.elixirgames.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.nooc.elixirgames.modelo.Games
import cl.nooc.elixirgames.modelo.GamesItem
import cl.nooc.elixirgames.room.GamesDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamesRepo(var context: Context){

    private val db = GamesDB.getInstancia(context)

    fun agregar(games: Games){
        CoroutineScope(Dispatchers.IO).launch {
            db.gamesDao().agregar(games)
        }
    }

    fun listar(): LiveData<Games> {
        return db.gamesDao().listar()
    }

    fun buscar(id:String): GamesItem{
        return db.gamesDao().buscar(id)
    }

    fun getCount(): Int{
        return db.gamesDao().contar()
    }
}