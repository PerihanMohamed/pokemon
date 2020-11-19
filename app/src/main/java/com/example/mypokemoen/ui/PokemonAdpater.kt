package com.example.mypokemoen.ui

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypokemoen.R
import com.example.mypokemoen.model.Poekmon
import com.example.mypokemoen.model.PoekmonResponse
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdpater(): RecyclerView.Adapter<PokemonAdpater.PokemonViewHolder>() {

      private var data :List <Poekmon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       return PokemonViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false))
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

            return  holder.bind(data[position])

    }

    fun swapData(data: List<Poekmon>) {
        this.data = data
        notifyDataSetChanged()
    }
    fun getPokemonPosition(position: Int): Poekmon{
      return   data.get(position)
    }

    class PokemonViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

          fun bind(data :Poekmon ){

              itemView.pokemon_name_textView.text  = data.name


                Glide.with(itemView.context)
                     .load(data.url)
                    .into(itemView.pokemon_imageView)


          }


    }


}