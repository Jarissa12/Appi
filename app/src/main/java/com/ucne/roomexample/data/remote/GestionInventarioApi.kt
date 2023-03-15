package com.ucne.roomexample.data.remote

import com.ucne.roomexample.data.remote.dto.ArticuloDto
import retrofit2.http.GET

interface GestionInventarioApi {
    @GET("/api/articulos")
    suspend fun getList(): List<ArticuloDto>
}

