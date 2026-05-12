package com.example.ordinario_23414

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ordinario_23414.ordinario.ChuckNorrisview
import com.example.ordinario_23414.ordinario.ChisteGuardado
import com.example.ordinario_23414.ordinario.OrdinarioDataStore
import com.example.ordinario_23414.ordinario.SeriesYPeliculasFamosas
import com.example.ordinario_23414.ui.theme.Ordinario_23414Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ordinario_23414Theme {
                val dataStore = remember { OrdinarioDataStore(this@MainActivity) }
                val scope = rememberCoroutineScope()
                val chisteGuardado by dataStore.chisteGuardado.collectAsState(
                    initial = ChisteGuardado()
                )
                var mostrarSeries by remember { mutableStateOf(false) }

                if (mostrarSeries) {
                    SeriesYPeliculasFamosas(
                        onRegresar = {
                            mostrarSeries = false
                        },
                        onGuardar = { chiste ->
                            scope.launch {
                                dataStore.guardarChiste(chiste)
                            }
                        }
                    )
                } else {
                    ChuckNorrisview(
                        onComenzar = {
                            mostrarSeries = true
                        },
                        chisteGuardado = chisteGuardado
                    )
                }
            }
        }
    }
}



/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ordinario_23414Theme {
        Greeting("Android")
    }
}*/
