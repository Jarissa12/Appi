package com.ucne.roomexample.data.repository

import com.ucne.roomexample.data.remote.GestionInventarioApi
import com.ucne.roomexample.data.remote.dto.ArticuloDto
import com.ucne.roomexample.util.Resource
import javax.inject.Inject

class ArticuloRepository @Inject constructor(
    private val gestionInventarioApi: GestionInventarioApi
) {

}