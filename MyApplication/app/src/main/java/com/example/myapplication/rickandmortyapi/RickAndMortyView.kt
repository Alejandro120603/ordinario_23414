package com.example.myapplication.rickandmortyapi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

// Paso 1: Pantalla simple para probar Rick and Morty API.
@Composable
fun RickAndMortyView(rickAndMortyViewModel: RickAndMortyViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Personaje Rick and Morty")

        Button(onClick = {
            // Paso 2: Cada click consulta un personaje aleatorio.
            rickAndMortyViewModel.traerRickAndMortyAleatorio()
        }) {
            Text(text = "Mostrar personaje aleatorio")
        }

        if (rickAndMortyViewModel.isLoading) {
            CircularProgressIndicator()
        }

        if (rickAndMortyViewModel.error.isNotBlank()) {
            Text(text = rickAndMortyViewModel.error)
        }

        if (rickAndMortyViewModel.nombre.isNotBlank()) {
            // Paso 3: Mostrar los campos solicitados.
            Text(text = "Nombre: ${rickAndMortyViewModel.nombre}")
            Text(text = "Status: ${rickAndMortyViewModel.status}")
            Text(text = "Especie: ${rickAndMortyViewModel.especie}")
            Text(text = "Gender: ${rickAndMortyViewModel.gender}")
        }

        if (rickAndMortyViewModel.imageUrl.isNotBlank()) {
            AsyncImage(
                model = rickAndMortyViewModel.imageUrl,
                contentDescription = "Imagen del personaje"
            )
        }
    }
}
