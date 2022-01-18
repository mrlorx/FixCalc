package com.mrlorx.fixcalc.storage

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mrlorx.fixcalc.Item

interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM items WHERE id = :id")
    fun get(id: Long): Item

    @Query("SELECT * FROM items WHERE screenId = :id")
    fun getFromScreenId(id: Long): LiveData<List<Item>>

    @Insert
    suspend fun insertNew(item: Item): Long

    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun update(item: Item)
}