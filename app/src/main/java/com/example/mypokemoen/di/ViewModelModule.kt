package com.example.mypokemoen.di

import android.annotation.SuppressLint
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypokemoen.model.Poekmon
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.math.PI

class ViewModelModule @ViewModelInject constructor(val pokemonRepositoryModule: PokemonRepositoryModule) : ViewModel() {


     val pokemonList : MutableLiveData<List<Poekmon>> = MutableLiveData()

     lateinit var favPokemonList : LiveData<List<Poekmon>>


    @SuppressLint("CheckResult")
    fun getPokemons() {

        pokemonRepositoryModule .getAllPokemons()
            .subscribeOn(Schedulers.io())

            .map {
                val list: List<Poekmon> = it.results
                for (pok in list) {
                    val url = pok.url
                    val pokemonIndex: List<String> =
                        url.split("/")
                    pok.url =
                        "https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex.size.minus(1) + ".png"

                }
                return@map list

            }









            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(

                {
                    pokemonList.postValue(it)


                }, {
//                    Log.e("viewModel" , it.message!!)
                    Log.e("viwModel", it.message!!)
                }
            )
//            )

    }

    fun insertPokemon(poekmon: Poekmon) = pokemonRepositoryModule.insert(poekmon)

    fun deletePokemon(poekmon: Poekmon) = pokemonRepositoryModule.delete(poekmon)

    fun getAllfavPokemon(){

       favPokemonList  = pokemonRepositoryModule.getAllFavPokemon()

}






}