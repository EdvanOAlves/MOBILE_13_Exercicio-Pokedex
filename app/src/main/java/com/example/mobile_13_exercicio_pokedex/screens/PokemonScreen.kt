package com.example.mobile_13_exercicio_pokedex.screens

import android.R.attr.contentDescription
import android.R.attr.font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mobile_13_exercicio_pokedex.R

@Composable
fun PokemonScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color(60, 211, 94, 255)),
        verticalArrangement = Arrangement.spacedBy(124.dp)

    ) {
        PokemonScreenHeader(name = "Bulbasaur", entry = "#001")
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                    contentDescription = "Sprite pokemon",
                    modifier = Modifier
                        .height(200.dp)
                        .background(Color.Transparent)
                        .offset(y= -48.dp),
                )
                //Types
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Type(text = "Grass", color = Color(60, 211, 94, 255))
                    Type(text = "Poison", color = Color(116, 53, 182, 255))

                }
                DetailTitle(text = "About")

                //Data
                Row() {
                    Measurement(
                        Modifier,
                        "Weight",
                        "6,9 kg",
                        painterResource(R.drawable.weighticon)
                    )
                    Measurement(Modifier, "Height", "0,7 m", painterResource(R.drawable.heighticon))


                    Column() {
                        Text("Chlorophyll")
                        Text("Overgrow")
                        Text("Abilities")
                    }
                }


                //Description
                Text(text = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.")


            }
        }
    }

}

@Composable
fun PokemonScreenHeader(name:String, entry:String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = {
                    /*TODO*/
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(text = entry.toString())
    }
}

@Composable
fun Type(modifier: Modifier = Modifier, text: String, color: Color) {
    Text(
        modifier = Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(100)
            )
            .padding(horizontal = 6.dp),
        text = text,

        )

}

@Composable
fun DetailTitle(modifier: Modifier = Modifier, text: String) {

}

@Composable
fun Measurement(
    modifier: Modifier = Modifier,
    fieldName: String,
    fieldValue: String,
    painter: Painter
) {
    Column() { //TODO: Deve virar um componente isso
        Row() {
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                painter = painter,
                contentDescription = "",
            )
            Text(fieldValue)
        }
        Text(fieldName)
    }

}