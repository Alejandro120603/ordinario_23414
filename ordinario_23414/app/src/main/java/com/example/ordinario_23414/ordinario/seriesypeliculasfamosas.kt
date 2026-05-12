package com.example.ordinario_23414.ordinario

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.actividad1am.R

private data class SeriePelicula(
    val titulo: String,
    val imagen: Int
)

@Composable
@SuppressLint("ViewModelConstructorInComposable")
fun SeriesYPeliculasFamosas(
    modifier: Modifier = Modifier,
    onRegresar: () -> Unit = {},
    onGuardar: (ChisteGuardado) -> Unit = {}
) {
    SeriesYPeliculasFamosas(
        viewModel = remember { ChuckNorrisViewModel() },
        modifier = modifier,
        onRegresar = onRegresar,
        onGuardar = onGuardar
    )
}

@Composable
fun SeriesYPeliculasFamosas(
    viewModel: ChuckNorrisViewModel,
    modifier: Modifier = Modifier,
    onRegresar: () -> Unit = {},
    onGuardar: (ChisteGuardado) -> Unit = {}
) {
    val seriesPeliculas = listOf(
        SeriePelicula("McQuade, el lobo solitario", R.drawable.mcquade),
        SeriePelicula("Prisionero de guerra", R.drawable.prisionero),
        SeriePelicula("Walker, Texas Ranger", R.drawable.texas_ranger),
        SeriePelicula("Logan's War: Bound by Honor", R.drawable.logan),
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Series y peliculas famosas",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(seriesPeliculas) { item ->
                SeriePeliculaCard(item)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ChuckNorrisApiCard(
            viewModel = viewModel,
            onRegresar = onRegresar,
            onGuardar = onGuardar
        )
    }
}

@Composable
private fun SeriePeliculaCard(
    item: SeriePelicula
) {
    Card(
        modifier = Modifier.width(136.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F2F2))
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.imagen),
                contentDescription = item.titulo,
                modifier = Modifier
                    .width(120.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = item.titulo,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(120.dp)
                    .padding(top = 6.dp)
            )
        }
    }
}

@Composable
private fun ChuckNorrisApiCard(
    viewModel: ChuckNorrisViewModel,
    onRegresar: () -> Unit,
    onGuardar: (ChisteGuardado) -> Unit
) {
    var mensajeGuardado by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            if (viewModel.iconUrl.isNotEmpty()) {
                AsyncImage(
                    model = viewModel.iconUrl,
                    contentDescription = "Icono Chuck Norris",
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Fit
                )
            }

            if (viewModel.chisteApi.isNotEmpty()) {
                Text(
                    text = "\"${viewModel.chisteApi}\"",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            if (viewModel.id.isNotEmpty()) {
                Text(
                    text = "ID: ${viewModel.id}",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

            if (viewModel.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(32.dp)
                )
            }

            if (viewModel.error.isNotEmpty()) {
                Text(
                    text = viewModel.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onRegresar) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.Black
                    )
                }

                IconButton(
                    onClick = {
                        if (viewModel.chisteApi.isNotEmpty()) {
                            onGuardar(
                                ChisteGuardado(
                                    frase = viewModel.chisteApi,
                                    autor = "Chuck Norris"
                                )
                            )
                            mensajeGuardado = "Chiste guardado"
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = "Guardar",
                        tint = Color.Black
                    )
                }

                IconButton(
                    onClick = {
                        viewModel.traerChisteRandom()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Traer otro chiste",
                        tint = Color.Black
                    )
                }
            }

            if (mensajeGuardado.isNotEmpty()) {
                Text(
                    text = mensajeGuardado,
                    color = Color(0xFF5E7C16),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SeriesYPeliculasFamosasPreview() {
    MaterialTheme {
        SeriesYPeliculasFamosas()
    }
}
