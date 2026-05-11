package com.example.primerparcial_23414.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primerparcial_23414.R


@Preview (showBackground = true)
@Composable
fun pantalla_apagada(){
    Column() {
        pantalla()
    }

}


@Composable
fun Cajita() {
    var imagenActual by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = when (imagenActual) {
                    0 -> R.drawable.sonic
                    1 -> R.drawable.akuma
                    2 -> R.drawable.mii
                    else -> R.drawable.fireemblem
                }
            ),
            contentDescription = "Imagen de portada",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun dostercio(){
    Row() { Image(
        painter = painterResource(id = R.drawable.fireemblem),
        contentDescription = "Imagen de portada",
        contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp)
    )
        Box(
            modifier = Modifier.
                size(100.dp)
                .background(Color.Black)
        )
        Image(
            painter = painterResource(id = R.drawable.sergio_canales),
            contentDescription = "Imagen de portada",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(100.dp)
        )
    }
    }

@Composable
fun untercio(){
    Row() {
    Box(
        modifier = Modifier.
        size(100.dp)
            .background(Color.Black)
    )
    Image(
        painter = painterResource(id = R.drawable.mii),
        contentDescription = "Imagen de portada",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(100.dp)
    )
    Box(
        modifier = Modifier.
        size(100.dp)
            .background(Color.Black)
    )
    }}

@Composable
fun trestercio(){
    Row() {
        Box(
            modifier = Modifier.
            size(100.dp)
                .background(Color.Black)
        )
        Image(
            painter = painterResource(id = R.drawable.sonic),
            contentDescription = "Imagen de portada",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(100.dp)
        )
        Box(
            modifier = Modifier.
            size(100.dp)
                .background(Color.Black)
        )
    }}

@Composable
fun cuadronegro(){
    Box(modifier = Modifier
        .size(300.dp)
        .background(Color.Black)){
        Column(){
            untercio()
            dostercio()
            trestercio()
        }
    }

}
@Composable
fun imagenes(){
    Column(){
        untercio()
        dostercio()
        trestercio()
    }
}

@Composable
fun pantalla(){

    Column(modifier = Modifier
        .width(300.dp)
        .height(600.dp)
        .background(Color(0xFF2DB1CD))
        .padding(all = 8.dp)){
        cuadronegro()
        botones()
    }


}
@Composable
fun botones (){
    var imagenActual by remember {
        mutableStateOf(0)
    }
    Box(){
        Column() {
            Row() {
                Box(
                    modifier = Modifier.
                    size(100.dp)
                        .background(Color(0xFF2DB1CD))
                )
                Image(
                    painter = painterResource(id = R.drawable.up_arrow),
                    contentDescription = "Imagen de portada",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(100.dp)
                )
                Box(
                    modifier = Modifier.
                    size(100.dp)
                        .background(Color(0xFF2DB1CD))
                )
            }
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.left_arrow),
                    contentDescription = "Imagen de portada",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(100.dp)
                )
                Box(
                    modifier = Modifier.
                    size(100.dp)
                        .background(Color(0xFF2DB1CD))
                )
                Image(
                    painter = painterResource(id = R.drawable.right_arrow),
                    contentDescription = "Imagen de portada",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(100.dp)
                )
            }
        Row() {
            Box(
                modifier = Modifier.
                size(100.dp)
                    .background(Color(0xFF2DB1CD))
            )
            Image(
                painter = painterResource(id = R.drawable.down_arrow),
                contentDescription = "Imagen de portada",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp)
            )
            Box(
                modifier = Modifier.
                size(100.dp)
                    .background(Color(0xFF2DB1CD))
            )
        }
        }
    }
}
