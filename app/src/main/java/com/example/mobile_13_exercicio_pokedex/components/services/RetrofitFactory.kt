package com.example.mobile_13_exercicio_pokedex.components.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofitFactory = Retrofit
        .Builder() // Declarando que vamos querer o builder
        .addConverterFactory(GsonConverterFactory.create()) //Declarando que vamos querer um conversor para Gson
        .baseUrl(BASE_URL) // Declarando a rota
        .build() //Instanciando com as configurações inseridas

    fun getPokemonService(): PokemonService{
        return retrofitFactory.create(PokemonService::class.java)
    }
}