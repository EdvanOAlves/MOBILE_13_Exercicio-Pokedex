package com.example.mobile_13_exercicio_pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_13_exercicio_pokedex.screens.PokemonScreen
import com.example.mobile_13_exercicio_pokedex.screens.StartScreen
import com.example.mobile_13_exercicio_pokedex.ui.theme.MOBILE_13_ExercicioPokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MOBILE_13_ExercicioPokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    StartScreen(modifier = Modifier.padding(innerPadding))
                    PokemonScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

