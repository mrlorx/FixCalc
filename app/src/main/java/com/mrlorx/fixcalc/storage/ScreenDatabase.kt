package com.mrlorx.fixcalc.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrlorx.fixcalc.Screen

@Database(entities = [Screen::class], version = 1)
abstract class ScreenDatabase : RoomDatabase() {
    abstract fun screenDao(): ScreenDao

    companion object {
        @Volatile private var INSTANCE: ScreenDatabase? = null

        fun getDatabase(context: Context): ScreenDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ScreenDatabase::class.java,
                    "screen_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}