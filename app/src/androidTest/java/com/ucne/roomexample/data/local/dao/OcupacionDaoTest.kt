package com.ucne.roomexample.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.ucne.roomexample.data.local.RoomExpampleDb
import com.ucne.roomexample.data.local.entity.OcupacionEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class OcupacionDaoTest {

    private  lateinit var database: RoomExpampleDb
    private lateinit var dao : OcupacionDao

    @Before
    fun setUp() {
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RoomExpampleDb::class.java
        ).allowMainThreadQueries().build()

        dao= database.ocupacionDao
    }

    @Test
    fun Insert_Ocupacion_Is_Success() = runBlocking {
        //arrange
        val id=1
        val ocupacionInsertar = OcupacionEntity(
            ocupacionId = id,
            descripcion = "Ingeniero Sistemas",
            sueldo = 0.0
        )

        //act
        dao.insert(ocupacionInsertar)
        var ocupacionBuscada = dao.find(id)

        //ocupacionBuscada=  ocupacionBuscada?.copy(sueldo = 10.0)
        //assert
        Truth.assertThat(ocupacionBuscada).isEqualTo(ocupacionInsertar)

    }

    @After
    fun tearDown() {
        database.close()
    }
}
