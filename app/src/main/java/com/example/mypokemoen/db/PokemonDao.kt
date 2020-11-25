package com.example.mypokemoen.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mypokemoen.model.Poekmon

@Dao
interface PokemonDao {

    @Insert
     fun insert(pokemon:Poekmon)

     @Delete
     fun delete(pokemon: Poekmon)

    @Query("SELECT * FROM poekmon_table ")
    fun getAllPokemons(): LiveData<List<Poekmon>>

}