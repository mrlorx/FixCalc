package com.mrlorx.fixcalc.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrlorx.fixcalc.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
