package com.ucne.roomexample.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.ucne.roomexample.data.local.RoomExpampleDb
import com.ucne.roomexample.data.remote.GestionInventarioApi
import com.ucne.roomexample.data.remote.TePrestoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): RoomExpampleDb {
        return Room.databaseBuilder(
            context,
            RoomExpampleDb::class.java,
            "RoomExample.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesOcupacionDao(db: RoomExpampleDb) = db.ocupacionDao

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesGestionInventarioApi(moshi: Moshi): GestionInventarioApi {
        return Retrofit.Builder()
            .baseUrl("https://gestioninventario.azurewebsites.net")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(GestionInventarioApi::class.java)
    }
    @Singleton
    @Provides
    fun providesTePrestoApi(moshi: Moshi): TePrestoApi {
        return Retrofit.Builder()
            .baseUrl("https://teprestoapi.azurewebsites.net")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(TePrestoApi::class.java)
    }

}