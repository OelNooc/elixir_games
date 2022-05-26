package cl.nooc.elixirgames.service

import cl.nooc.elixirgames.modelo.GameDetail
import cl.nooc.elixirgames.modelo.Games
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GamesService {

    @GET("games")
    fun getGames() : Call<Games>

    @GET("gameDetails/{id}")
    fun getGamesDetail(@Path("id") id:Int) : Call<GameDetail>
}