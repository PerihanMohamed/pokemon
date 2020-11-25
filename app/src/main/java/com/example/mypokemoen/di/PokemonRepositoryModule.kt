package com.example.mypokemoen.di

import androidx.lifecycle.LiveData
import com.example.mypokemoen.data.ApiService
import com.example.mypokemoen.db.PokemonDao

import com.example.mypokemoen.model.Poekmon
import com.example.mypokemoen.model.PoekmonResponse
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PokemonRepositoryModule @Inject constructor(val apiService: ApiService , val pokemondao : PokemonDao) {


    fun getAllPokemons(): Observable<PoekmonResponse> {

        return apiService.getPokemon()
    }


    fun insert(poekmon: Poekmon) = pokemondao.insert(poekmon)

    fun delete(poekmon: Poekmon ) = pokemondao.delete(poekmon)


    fun getAllFavPokemon() : LiveData<List<Poekmon>> = pokemondao.getAllPokemons()


}