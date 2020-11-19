package com.example.mypokemoen.ui.fav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemoen.R
import com.example.mypokemoen.di.ViewModelModule

import com.example.mypokemoen.ui.PokemonActivity
import kotlinx.android.synthetic.main.activity_favorite.*

//class FavoriteActivity : AppCompatActivity() {
//
//     lateinit var fviewModel: ViewModelModule
//     val favAdapter = FavoriteAdapter()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_favorite)
//
//        fviewModel = ViewModelProvider(this).get(ViewModelModule::class.java)
//
////        fviewModel.getAllfavPok().observe(this,  Observer {
////
////             favAdapter.swapData(it)
////       })
//
//
//        fav_recyclerView.layoutManager = LinearLayoutManager(this)
//        fav_recyclerView.adapter =favAdapter
//
//        to_home_button.setOnClickListener {
//            val intent = Intent(this, PokemonActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
//}