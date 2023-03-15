package com.ucne.roomexample.data.remote

import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import retrofit2.http.GET
import retrofit2.http.POST

interface TePrestoApi{
    @GET("/api/ocupaciones")
    suspend fun getOcupaciones(): List<OcupacionesDto>

    @POST("/api/Ocupaciones")
    suspend fun postOcupacion(ocupacionesDto: OcupacionesDto)
}