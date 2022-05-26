package cl.nooc.elixirgames.cliente

import cl.nooc.elixirgames.service.GamesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameDetailCliente {

        companion object{
            const val base_url = "https://my-json-server.typicode.com/himuravidal/gamesDB/"

            fun getInstance(url:String) : GamesService
            {
                val retrofit = Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(GamesService::class.java)
            }
        }
}