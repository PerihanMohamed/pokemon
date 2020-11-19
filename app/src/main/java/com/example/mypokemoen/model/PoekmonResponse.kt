package com.example.mypokemoen.model

data class PoekmonResponse(


    val results :List<Poekmon>,
    val count :Int ,
    val next : String ,
    val previous : String

)