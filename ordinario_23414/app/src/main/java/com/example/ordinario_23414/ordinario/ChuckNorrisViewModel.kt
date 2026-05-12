package com.example.ordinario_23414.ordinario

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChuckNorrisViewModel : ViewModel() {
    var id by mutableStateOf("")
        private set

    var iconUrl by mutableStateOf("")
        private set

    var chisteApi by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    fun traerChisteRandom() {
        val api = ChuckNorrisAPI()

        error = ""
        isLoading = true

        viewModelScope.launch {
            try {
                val chiste = withContext(Dispatchers.IO) {
                    api.getChisteRandom()
                }

                if (chiste != null) {
                    id = chiste.id.orEmpty()
                    iconUrl = chiste.iconUrl.orEmpty()
                    chisteApi = chiste.value.orEmpty()
                } else {
                    limpiarDatos()
                    error = "No se encontro el chiste."
                }
            } catch (exception: Exception) {
                limpiarDatos()
                error = "No se pudo consultar Chuck Norris API."
            } finally {
                isLoading = false
            }
        }
    }

    private fun limpiarDatos() {
        id = ""
        iconUrl = ""
        chisteApi = ""
    }
}
