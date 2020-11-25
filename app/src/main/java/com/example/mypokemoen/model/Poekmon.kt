package com.example.mypokemoen.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Poekmon_table")
data class Poekmon (

    @PrimaryKey(autoGenerate = true)
    val id :Int,
    @ColumnInfo(name = "pokemon")
    val name : String,

    var url :String




)