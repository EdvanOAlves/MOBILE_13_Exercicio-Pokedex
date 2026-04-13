package com.example.mobile_13_exercicio_pokedex.model

import com.google.gson.annotations.SerializedName


data class PokemonListResponse(
    val results: List<PokemonEntry>
)
class PokemonEntry (
    val name: String,
    val url: String,
){ var entryNumber: String = "0"
    get() = url
        .trimEnd('/')
        .split("/")
        .last()
    val thumbnailPath: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${entryNumber}.png"
}