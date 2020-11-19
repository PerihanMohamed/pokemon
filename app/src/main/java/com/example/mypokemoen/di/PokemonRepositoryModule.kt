package com.example.mypokemoen.di

import androidx.lifecycle.LiveData
import com.example.mypokemoen.data.ApiService

import com.example.mypokemoen.model.Poekmon
import com.example.mypokemoen.model.PoekmonResponse
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PokemonRepositoryModule @Inject constructor(val apiService: ApiService) {


    fun getAllPokemons(): Observable<PoekmonResponse> {

        return apiService.getPokemon()
    }

//    fun delete (poekmon: Poekmon) = db.pokemonDao().delete(poekmon)
//    fun insert(poekmon: Poekmon) = db.pokemonDao().insert(poekmon)
//    val allPokemons: LiveData<List<Poekmon>> = db.pokemonDao().getAllPokemons()
//
//    fun getfavoritePokemon(): LiveData<List<Poekmon>> = db.pokemonDao().getAllPokemons()

}