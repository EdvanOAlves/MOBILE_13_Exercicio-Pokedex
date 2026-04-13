package com.example.mobile_13_exercicio_pokedex.screens

import android.R.attr.contentDescription
import android.R.attr.label
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_13_exercicio_pokedex.R
import com.example.mobile_13_exercicio_pokedex.components.PokemonCard
import com.example.mobile_13_exercicio_pokedex.components.services.RetrofitFactory
import com.example.mobile_13_exercicio_pokedex.model.PokemonEntry
import com.example.mobile_13_exercicio_pokedex.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    val lightGray:Color = Color(225,225,225)
    val lightRed:Color = Color(255,94,94)
    val grayStroke:Color = Color(180,180,180)

    var searchState by remember { mutableStateOf("") }
    var pokemons by remember { mutableStateOf(listOf<PokemonEntry>()) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(lightRed)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(64.dp),
                painter = painterResource(R.drawable.avatar),
                contentDescription = "Ícone Breloom, creditos FlatIcon"
            )
            Text(
                text = "Pokédex",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        }
        Column (
            modifier = Modifier
                .padding(24.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchState,
                onValueChange = {/*TODO*/ },
                label = {
                    Text(
                    fontSize = 20.sp,
                    text = "Nome ou ID"
                ) },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            var call = RetrofitFactory().getPokemonService().getPokemonList()

                            call.enqueue(object: Callback<PokemonListResponse> {
                                override fun onResponse(
                                    call: Call<PokemonListResponse>,
                                    response: Response<PokemonListResponse>
                                ) {
                                    Log.i("TESTE", "${ response.body()!!.results }")
                                    pokemons = response.body()!!.results                                }

                                override fun onFailure(
                                    call: Call<PokemonListResponse>,
                                    t: Throwable
                                ) {
                                    Log.i("TESTE", "${t.message}")
                                }
                            })

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = grayStroke,
                    unfocusedBorderColor = grayStroke,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(35),
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp)
            ) {
                items(pokemons) {
//                    PokemonCard(it)
                }
            }
        }
    }
}