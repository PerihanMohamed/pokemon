package com.example.mypokemoen.di

import android.annotation.SuppressLint
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypokemoen.model.Poekmon
import com.example.mypokemoen.model.PoekmonResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelModule @ViewModelInject constructor (val pokemonRepositoryModule: PokemonRepositoryModule) : ViewModel() {

//    val pokemonLiveData : MutableLiveData<PoekmonResponse> = MutableLiveData()
    val pokemonList : MutableLiveData<List<Poekmon>> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getPokemons() {

        pokemonRepositoryModule .getAllPokemons()
            .subscribeOn(Schedulers.io())

            .map{
              val list : List<Poekmon> = it.results
                   for(pok in list ){
                       val url = pok.url
                       val pokemonIndex =
                           url.split("/".toRegex()).toTypedArray()
                       pok.url =
                           "https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex[pokemonIndex.size - 1] + ".png"

                   }
                return@map list

            }


            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(

                {
                    pokemonList.postValue(it)





                },{
//                    Log.e("viewModel" , it.message!!)
                    Log.e("viwModel", it.message!!)
                }
            )
//            )

    }

//    fun insertPokemon(poekmon: Poekmon) = pokemonRepositoryModule.insert(poekmon)
//    fun deletePokemon(poekmon: Poekmon) = pokemonRepositoryModule.delete(poekmon)
//
//
//
//    fun getAllfavPok() {
//
//        pokemonRepositoryModule.getfavoritePokemon()
//    }



}