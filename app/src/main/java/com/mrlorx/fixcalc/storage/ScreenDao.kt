package com.mrlorx.fixcalc.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mrlorx.fixcalc.Screen

@Dao
interface ScreenDao {
    @Query("SELECT * FROM screens")
    fun getAll(): LiveData<List<Screen>>

    @Query("SELECT * FROM screens WHERE id = :id")
    fun get(id: Long): Screen

    @Insert
    suspend fun insertNew(screen: Screen): Long

    @Delete
    suspend fun delete(id: Long)

    @Update
    suspend fun update(screen: Screen)
}