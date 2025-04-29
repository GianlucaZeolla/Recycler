package com.example.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter(val context: Context) : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {


    lateinit var onItemClicked: (Pokemon) -> Unit



    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val vida: TextView = view.findViewById(R.id.textView_vida)
        private val name: TextView = view.findViewById(R.id.textView_name)
        private val ataque: TextView = view.findViewById(R.id.textView_ataque)
        private val defensa: TextView = view.findViewById(R.id.textView_defensa)
        private val velocidad: TextView = view.findViewById(R.id.textView_velocidad)
        private val ImagenTipo: ImageView = view.findViewById(R.id.imageView_tipo)
        private val ImagenPokemon: ImageView = view.findViewById(R.id.imageView_imagen)




        fun bind (pokemon: Pokemon) {
            vida.text = "Vida :" + pokemon.vida.toString()
            name.text = "Nombre: " + pokemon.name
            ataque.text = "Ataque: " + pokemon.ataque.toString()
            defensa.text = "Defensa: " + pokemon.defensa.toString()
            velocidad.text = "Velocidad: " + pokemon.velocidad.toString()



            val image = when(pokemon.tipo) {
                TipoPokemon.AGUA -> R.drawable.ic_launcher_foreground
                TipoPokemon.PLANTA -> R.drawable.ic_launcher_foreground
                TipoPokemon.FUEGO -> R.drawable.ic_launcher_foreground
                TipoPokemon.ELECTRICO -> R.drawable.ic_launcher_foreground
                TipoPokemon.LUCHA -> R.drawable.ic_launcher_foreground
            }

            ImagenTipo.setImageResource(image)

            Glide.with(context)
                .load(pokemon.url)
                .into(ImagenPokemon)

            view.setOnClickListener{
                onItemClicked(pokemon)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}