package com.example.mypokemoen.ui.fav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemoen.R
import com.example.mypokemoen.di.ViewModelModule
import com.example.mypokemoen.model.Poekmon

import com.example.mypokemoen.ui.PokemonActivity
import com.example.mypokemoen.ui.PokemonAdpater
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_pokemon.*


@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {


       val adapter = PokemonAdpater()
       lateinit var viewModel:ViewModelModule



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)




        viewModel = ViewModelProvider(this).get(ViewModelModule::class.java)



           viewModel.getAllfavPokemon()

            viewModel.favPokemonList.observe(this , Observer {
                val list  : ArrayList<Poekmon> = ArrayList()
                    list.addAll(it)
                    adapter.swapData(list)
            })


        fav_recyclerView.layoutManager = LinearLayoutManager(this)
        fav_recyclerView.adapter =adapter

        to_home_button.setOnClickListener {
            val intent = Intent(this, PokemonActivity::class.java)
            startActivity(intent)
        }

        swipeUp()

    }


    fun swipeUp(){

        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val swipePosition = viewHolder.adapterPosition
                    val pokemonPosition = adapter.getPokemonPosition(swipePosition)
                    viewModel.deletePokemon(pokemonPosition)


                    Toast.makeText(
                        this@FavoriteActivity,
                        "this pokemon has been deleted to favList",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(fav_recyclerView)

    }
}