package com.example.mypokemoen.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemoen.R

import com.example.mypokemoen.di.ViewModelModule
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_pokemon.*

@AndroidEntryPoint
class PokemonActivity : AppCompatActivity() {


    lateinit var viewModel:ViewModelModule
//    lateinit var repository :PokemonRepository

//    private var db: PokemonDatabase? = null
    val adapter = PokemonAdpater()

    private val newWordActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

//        swipeUp()

//        db = PokemonDatabase.getDatabase(this)









        viewModel = ViewModelProvider(this).get(ViewModelModule::class.java)




        pokemon_recyclerView.layoutManager = LinearLayoutManager(this)
        pokemon_recyclerView.adapter =adapter



        viewModel.getPokemons().observe(this , Observer {
               adapter.swapData(it.results)
        })




//        to_fav_button
//        .setOnClickListener {
//            val intent = Intent(this, FavoriteActivity::class.java)
//            startActivityForResult(intent ,newWordActivityRequestCode)
//        }

    }


//    fun swipeUp(){
//
//        val itemTouchHelperCallback =
//            object :
//                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT ) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    target: RecyclerView.ViewHolder
//                ): Boolean {
//                    return false
//                }
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                     val swipePosition = viewHolder.adapterPosition
//                     val pokemonPosition = adapter.getPokemonPosition(swipePosition)
//                     viewModel.insertPokemon(pokemonPosition)
//
//
//                    Toast.makeText(
//                        this@PokemonActivity,
//                       "this pokemon has been added to favList",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            }
//
//        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
//        itemTouchHelper.attachToRecyclerView(pokemon_recyclerView)
//
//    }
}