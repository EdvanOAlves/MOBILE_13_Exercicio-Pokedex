package com.example.mobile_13_exercicio_pokedex.model


data class PokemonListResponse(
    val results: List<PokemonEntry>
)
class PokemonEntry (
    val name: String,
    val url: String,
    val entryNumber: String = url
        .trimEnd('/')
        .split("/")
        .last(),
    val thumbnailPath: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${entryNumber}.png",
)