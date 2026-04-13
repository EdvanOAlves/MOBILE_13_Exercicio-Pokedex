package com.example.mobile_13_exercicio_pokedex.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mobile_13_exercicio_pokedex.model.PokemonEntry
import com.example.mobile_13_exercicio_pokedex.screens.lightRed

@Composable
fun PokemonCard(pokemon:PokemonEntry, onClick: ()->Unit) {
    Card(modifier = Modifier
        .background(Color.Transparent)
        .clickable{onClick},
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, color = lightRed)
    ) {
        Column(Modifier
            .fillMaxSize()
            .background(Color.White)
        ) {
            Text(
                text = "#${pokemon.entryNumber}",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(horizontal = 6.dp),
                fontSize = 12.sp,
                color = lightRed,
                textAlign = TextAlign.Right,
            )
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.entryNumber}.png",
                contentDescription = "Sprite pokemon",
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Transparent)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightRed),
                text = pokemon.name.capitalize(),
                textAlign = TextAlign.Center
            )
        }
    }
}