package com.example.mobile_13_exercicio_pokedex.screens

import android.R.attr.contentDescription
import android.R.attr.font
import android.R.attr.fontWeight
import android.R.attr.text
import android.R.attr.x
import android.icu.text.ListFormatter
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.mobile_13_exercicio_pokedex.R
import org.w3c.dom.Text

val grassCol: Color = Color(60, 211, 94, 255)
val grassColTransparent: Color = Color(60, 211, 94, 100)
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
                .offset(y = -180.dp)
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(grassCol),
            verticalArrangement = Arrangement.spacedBy(150.dp),
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
                        .padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
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
                            .height(64.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Measurement(
                            "Weight",
                            "6,9 kg",
                            painterResource(R.drawable.weighticon),
                            modifier = Modifier.fillMaxHeight()
                        )
                        VerticalDivider(thickness = 2.dp, color = textGray)
                        Measurement(
                            "Height",
                            "0,7 m",
                            painterResource(R.drawable.heighticon),
                            modifier = Modifier.fillMaxHeight()
                        )
                        VerticalDivider(thickness = 2.dp, color = textGray)
                        Abilities(listOf("Chlorophyll", "Overgrow"))
                    }

                    //Description
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                        color = Color.Black,
                        fontSize = 14.sp,
                    )

                    //Stats
                    DetailTitle(text = "Base Stats")

                    Row(Modifier.fillMaxWidth()) {
                        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                            Stat(statName = "HP", 45)
                            Stat(statName = "ATK", 49)
                            Stat(statName = "DEF", 49)
                            Stat(statName = "SATK", 65)
                            Stat(statName = "SDEF", 65)
                            Stat(statName = "SPD", 45)

                        }
                    }

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
        fontWeight = FontWeight.Bold,
        color = Color.White

    )

}

@Composable
fun DetailTitle(text: String) {
    Text(
        text = text,
        color = grassCol,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold
    )

}

@Composable
fun Measurement( //TODO: Criar o arquivo de componentes
    fieldName: String,
    fieldValue: String,
    painter: Painter,
    modifier: Modifier

) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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
        //TODO: O alinhamento dos textos de medidas com o abilities ainda não tá 100%
    }
}

@Composable
fun Abilities(
    //TODO: Criar o arquivo de componentes
    abilities: List<String>,
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

@Composable
fun StatBar(stat: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        val fillPercentage: Float = stat.toFloat() / 255
        Row(
            Modifier
                .width(250.dp)
                .height(4.dp)
                .background(grassColTransparent, shape = RoundedCornerShape(100)),
        ) {
            Row(
                Modifier
                    .fillMaxWidth(fillPercentage)
                    .background(grassCol, shape = RoundedCornerShape(100))
            ) {
                Text("coconut", color = Color(0, 0, 0, 0))
            }

        }
    }
}

@Composable
fun Stat(statName: String, stat: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            modifier = Modifier.width(36.dp),
            text = statName,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            color = grassCol
        )
        Text(
            text = stat.toString(),
            color = Color.Black,
            fontSize = 14.sp,
        )

        StatBar(stat)

    }


}