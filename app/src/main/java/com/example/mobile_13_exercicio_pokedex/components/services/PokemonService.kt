package com.example.mobile_13_exercicio_pokedex.components.services

import android.telecom.Call
import com.example.mobile_13_exercicio_pokedex.model.PokemonEntry
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    //https://pokeapi.co/api/v2/pokemon
    @GET("")
    fun getPokemonList(
        @Path(value = "name") name:String,
        @Path(value = "url") url:String

    ): Call<List<PokemonEntry>>
}