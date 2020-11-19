package com.example.mypokemoen.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mypokemoen.model.Poekmon

//@Dao
//interface PokemonDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//     fun insert(pokemon:Poekmon)
//
//    @Query("Delete from `pokemon_table `")
//     fun delete(pokemon: Poekmon)
//
//    @Query("SELECT * from `pokemon_table `")
//    fun getAllPokemons(): LiveData<List<Poekmon>>
//
//}