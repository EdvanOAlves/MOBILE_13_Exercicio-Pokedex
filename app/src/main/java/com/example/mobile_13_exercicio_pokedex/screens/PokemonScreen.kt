package com.example.mobile_13_exercicio_pokedex.screens

import android.R.attr.contentDescription
import android.R.attr.font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.mobile_13_exercicio_pokedex.R
import org.w3c.dom.Text

val grassCol: Color = Color(60, 211, 94, 255)
val textGray: Color = Color(150, 150, 150)

@Composable
fun PokemonScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            contentDescription = "Sprite pokemon",
            modifier = Modifier
                .height(244.dp)
                .background(Color.Transparent)
                .zIndex(2f)
                .offset(y = -144.dp)
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(grassCol),
            verticalArrangement = Arrangement.spacedBy(180.dp),
            horizontalAlignment = Alignment.CenterHorizontally

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
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    //Types
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Type(text = "Grass", color = grassCol)
                        Type(text = "Poison", color = Color(116, 53, 182, 255))

                    }

                    //About
                    DetailTitle(text = "About")
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(72.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Measurement(
                            "Weight",
                            "6,9 kg",
                            painterResource(R.drawable.weighticon)
                        )
                        VerticalDivider(thickness = 2.dp, color = textGray)
                        Measurement(
                            "Height",
                            "0,7 m",
                            painterResource(R.drawable.heighticon)
                        )
                        VerticalDivider(thickness = 2.dp, color = textGray)
                        Abilities(listOf("Chlorophyll", "Overgrow"))
                    }

                    //Stats


                    //Description
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                        color = Color.Black,
                        fontSize = 14.sp,

                    )
                    DetailTitle(text ="Base Stats")


                }
            }
        }

    }

}

@Composable
fun PokemonScreenHeader(name: String, entry: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
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
        Text(text = entry.toString(), fontWeight = FontWeight.Bold)
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
        fontWeight = FontWeight.Bold

        )

}

@Composable
fun DetailTitle(text: String) {
    Text(
        text = text,
        color = grassCol,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

}

@Composable
fun Measurement( //TODO: Criar o arquivo de componentes
    fieldName: String,
    fieldValue: String,
    painter: Painter
) {
    Column(
        Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                painter = painter,
                contentDescription = "",
            )
            Text(fieldValue, color = Color.Black)
        }
        MeasurementName(fieldName)
    }
}
@Composable
fun Abilities( //TODO: Criar o arquivo de componentes
    abilities:List<String>,
) {
    Column(
        Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        abilities.forEach { Text(it, color = Color.Black) }
        MeasurementName("Abilities")
    }
}

@Composable
fun MeasurementName(fieldName: String) {
    Text(
        fieldName,
        color = textGray,
        fontSize = 12.sp
    )
}