package cl.nooc.elixirgames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.nooc.elixirgames.R
import cl.nooc.elixirgames.databinding.GamesLayoutBinding
import cl.nooc.elixirgames.modelo.Games
import cl.nooc.elixirgames.modelo.GamesItem
import com.squareup.picasso.Picasso
import java.util.*

class GamesAdapter: RecyclerView.Adapter<GamesAdapter.CustomViewHolder>() {

    var lista = ArrayList<GamesItem>()
    lateinit var listener: MiListener

    class CustomViewHolder(itemView: View, val listener: MiListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = GamesLayoutBinding.bind(itemView)

        fun bindData(game: GamesItem)
        {
            with(binding)
            {
                Picasso.get().load(game.background_image)
                tvNameGame.text = game.name
                tvGameOut.text = game.released
                itemView.setOnClickListener {
                    listener.miOnClick(game)
                }
            }
        }
    }

    interface MiListener{
        fun miOnClick(game:GamesItem)
    }

    fun setMiListener(listener: MiListener)
    {
        this.listener = listener
    }

    fun updateData(games: Games)
    {
        lista = games
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.games_layout, parent, false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int = lista.size
}