package com.ucne.roomexample.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ucne.roomexample.data.remote.dto.OcupacionesDto

@Entity(tableName = "Ocupaciones")
data class OcupacionEntity(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int? = null,
    val descripcion: String,
    val sueldo: Double,
    val enviado: Boolean = false
)

fun OcupacionEntity.toOcupacionDto(): OcupacionesDto {
    return OcupacionesDto(
        ocupacionId = this.ocupacionId ?: 0,
        descripcion = this.descripcion,
        sueldo = this.sueldo
    )
}