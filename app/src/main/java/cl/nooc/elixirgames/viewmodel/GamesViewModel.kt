package cl.nooc.elixirgames.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.nooc.elixirgames.modelo.GameDetail
import cl.nooc.elixirgames.modelo.Games
import cl.nooc.elixirgames.modelo.GamesItem
import cl.nooc.elixirgames.repository.GameDetailClienteRepo
import cl.nooc.elixirgames.repository.GameDetailRepo
import cl.nooc.elixirgames.repository.GamesClienteRepo
import cl.nooc.elixirgames.repository.GamesRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GamesViewModel (application: Application) : AndroidViewModel(application) {

    private val clienteGamesRepo = GamesClienteRepo()
    private lateinit var clienteDetalleRepo: GameDetailClienteRepo
    private val gamesRepo = GamesRepo(getApplication())
    private val gameDetailRepo = GameDetailRepo(getApplication())

    val games = gamesRepo.listar()
    val gameDetail = MutableLiveData<GameDetail>()
    val game = MutableLiveData<GamesItem>()

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            if (gamesRepo.getCount() == 0) {
                clienteGamesRepo.getListaGames().enqueue(object : Callback<Games> {
                    override fun onResponse(call: Call<Games>, response: Response<Games>) {
                        response.body().let {
                            gamesRepo.agregar(it!!)
                        }
                    }

                    override fun onFailure(call: Call<Games>, t: Throwable) {
                        Log.e("CALL", t.message.toString())
                    }
                })
            }
        }
    }

    fun getDetail() {
        clienteDetalleRepo = GameDetailClienteRepo(game)
        CoroutineScope(Dispatchers.IO).launch {
            if (gameDetailRepo.getCount() == 0) {
                clienteDetalleRepo.getListaGames().enqueue(object : Callback<GameDetail> {
                    override fun onResponse(call: Call<GameDetail>, response: Response<GameDetail>) {
                        response.body().let {
                            gameDetailRepo.agregar(it!!)
                        }
                    }

                    override fun onFailure(call: Call<GameDetail>, t: Throwable) {
                        Log.e("CALL", t.message.toString())
                    }
                })
            }
        }
    }
}