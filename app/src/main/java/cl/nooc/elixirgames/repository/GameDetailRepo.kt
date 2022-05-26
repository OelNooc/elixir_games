package cl.nooc.elixirgames.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.nooc.elixirgames.modelo.GameDetail
import cl.nooc.elixirgames.room.GameDetailDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameDetailRepo(var context: Context) {

    private val db = GameDetailDB.getInstancia(context)

    fun agregar(game: GameDetail){
        CoroutineScope(Dispatchers.IO).launch {
            db.gameDetailDao().agregar(game)
        }
    }

    fun listar(): LiveData<GameDetail> {
        return db.gameDetailDao().listar()
    }

    fun buscar(id:String): GameDetail{
        return db.gameDetailDao().buscar(id)
    }

    fun getCount(): Int{
        return db.gameDetailDao().contar()
    }
}