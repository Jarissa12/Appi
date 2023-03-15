package com.ucne.roomexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.roomexample.data.local.dao.OcupacionDao
import com.ucne.roomexample.data.local.entity.OcupacionEntity

@Database(
    entities = [
        OcupacionEntity::class
    ],
    version = 1
)
abstract class RoomExpampleDb: RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
}