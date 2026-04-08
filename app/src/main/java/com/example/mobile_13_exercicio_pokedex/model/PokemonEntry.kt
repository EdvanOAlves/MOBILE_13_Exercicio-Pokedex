package com.example.mobile_13_exercicio_pokedex.model

class PokemonEntry (
    val name: String,
    val route: String,

    val id: Integer = route.split(),
    val thumbnail: String
)