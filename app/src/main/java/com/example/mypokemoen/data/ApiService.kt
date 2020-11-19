package com.example.mypokemoen.data

import com.example.mypokemoen.model.PoekmonResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

import retrofit2.http.GET


    interface ApiService {


        companion object{
            const val BASE_URL = "https://pokeapi.co/api/v2/"
        }

    //pokeapi.co/api/v2/pokemon
    @GET("pokemon/")
    fun getPokemon() : Observable<PoekmonResponse>

}