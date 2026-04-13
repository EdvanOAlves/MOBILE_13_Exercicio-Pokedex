package com.example.mobile_13_exercicio_pokedex.components.services

import com.example.mobile_13_exercicio_pokedex.model.PokemonEntry
import com.example.mobile_13_exercicio_pokedex.model.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    // https://pokeapi.co/api/v2/pokemon?limit=100
    //Lidar melhor com esse limit depois
    @GET("pokemon?limit=1025")
    fun getPokemonList(): Call<PokemonListResponse>
}