package com.mrlorx.fixcalc.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrlorx.fixcalc.Screen

@Database(entities = [Screen::class], version = 1)
abstract class ScreenDatabase : RoomDatabase() {
    abstract fun screenDao(): ScreenDao
}