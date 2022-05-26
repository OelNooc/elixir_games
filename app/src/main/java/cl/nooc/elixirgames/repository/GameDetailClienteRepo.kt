package cl.nooc.elixirgames.repository

import androidx.lifecycle.MutableLiveData
import cl.nooc.elixirgames.cliente.GameDetailCliente
import cl.nooc.elixirgames.modelo.GameDetail
import cl.nooc.elixirgames.modelo.GamesItem
import retrofit2.Call

class GameDetailClienteRepo(val game: MutableLiveData<GamesItem>) {

    private val cliente = GameDetailCliente.getInstance(GameDetailCliente.base_url)

    fun getListaGames(): Call<GameDetail> {
        return cliente.getGamesDetail(game.value!!.id)
    }
}