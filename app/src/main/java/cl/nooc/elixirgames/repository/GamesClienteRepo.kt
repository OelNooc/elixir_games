package cl.nooc.elixirgames.repository

import cl.nooc.elixirgames.cliente.GamesCliente
import cl.nooc.elixirgames.modelo.Games
import retrofit2.Call

class GamesClienteRepo {

    private val cliente = GamesCliente.getInstance(GamesCliente.base_url)

    fun getListaGames(): Call<Games> {
        return cliente.getGames()
    }
}