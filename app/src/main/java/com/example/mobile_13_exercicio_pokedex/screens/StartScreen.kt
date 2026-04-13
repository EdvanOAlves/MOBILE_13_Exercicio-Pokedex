package com.example.mobile_13_exercicio_pokedex.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mobile_13_exercicio_pokedex.R
import com.example.mobile_13_exercicio_pokedex.components.PokemonCard
import com.example.mobile_13_exercicio_pokedex.services.RetrofitFactory
import com.example.mobile_13_exercicio_pokedex.model.PokemonEntry
import com.example.mobile_13_exercicio_pokedex.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    val lightGray:Color = Color(225,225,225)
    val lightRed:Color = Color(255,94,94)
    val grayStroke:Color = Color(180,180,180)
@Composable
fun StartScreen(modifier: Modifier = Modifier) {

    var searchState by remember { mutableStateOf("") }
    var pokemons by remember { mutableStateOf(listOf<PokemonEntry>()) }


    /*TODO: Migrar para a viewmodel*/
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
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
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
                            /*TODO*/
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
                columns = GridCells.Adaptive(120.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(pokemons) {
                    PokemonCard(it, {})
                }

//                items(25){
//                    cardExemplo()
//                }

            }
        }
    }
}

@Composable
fun cardExemplo(modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, color = lightRed)
    ) {
        Column(Modifier
            .fillMaxSize()
            .background(Color.White)
        ) {
            Text(
                text = "#001",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(horizontal = 6.dp),
                fontSize = 12.sp,
                color = lightRed,
                textAlign = TextAlign.Right,
            )
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                contentDescription = "Sprite pokemon",
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Transparent)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightRed),
                text = "Bulbasaur",
                textAlign = TextAlign.Center
            )
        }
    }
}
