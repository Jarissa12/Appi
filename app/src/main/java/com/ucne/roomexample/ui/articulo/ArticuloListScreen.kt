package com.ucne.roomexample.ui.ocupacion

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ucne.roomexample.data.remote.dto.ArticuloDto

@Composable
fun ArticuloListScreen(articulos: List<ArticuloDto>) {
    LazyColumn() {
        items(articulos) { art ->
            ArticuloRow(art)
        }
    }
}

@Composable
fun ArticuloRow(articuloDto: ArticuloDto) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = articuloDto.descripcion, style = MaterialTheme.typography.titleLarge)
        Text(text = articuloDto.precio.toString())
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArticuloListScreenPreview() {
    var articulos = listOf(
        ArticuloDto(1, "Disco ssd", "", 100.0, 1),
        ArticuloDto(1, "Camara", "", 200.0, 1)
    )
    ArticuloListScreen(articulos)
}