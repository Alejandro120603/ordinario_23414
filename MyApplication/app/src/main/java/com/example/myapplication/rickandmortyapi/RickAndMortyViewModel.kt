package com.example.myapplication.rickandmortyapi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Paso 1: ViewModel que guarda los datos que Compose va a mostrar.
class RickAndMortyViewModel : ViewModel() {

    var nombre by mutableStateOf("")
        private set

    var status by mutableStateOf("")
        private set

    var especie by mutableStateOf("")
        private set

    var gender by mutableStateOf("")
        private set

    var imageUrl by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    fun traerRickAndMortyAleatorio() {
        val api = RickAndMortyAPI()

        error = ""
        isLoading = true

        viewModelScope.launch {
            try {
                // Paso 2: Consultar internet en Dispatchers.IO para no bloquear la pantalla.
                val personaje = withContext(Dispatchers.IO) {
                    api.getPersonajeAleatorio()
                }

                if (personaje != null) {
                    // Paso 3: Llenar los estados con los campos solicitados.
                    nombre = personaje.name ?: ""
                    status = personaje.status ?: ""
                    especie = personaje.species ?: ""
                    gender = personaje.gender ?: ""
                    imageUrl = personaje.image ?: ""
                } else {
                    limpiarDatos()
                    error = "No se encontró el personaje."
                }
            } catch (exception: Exception) {
                limpiarDatos()
                error = "No se pudo consultar Rick and Morty API."
            } finally {
                // Paso 4: Apagar loading al terminar.
                isLoading = false
            }
        }
    }

    private fun limpiarDatos() {
        nombre = ""
        status = ""
        especie = ""
        gender = ""
        imageUrl = ""
    }
}
