package com.mrlorx.fixcalc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "screens")
data class Screen (
    @PrimaryKey(autoGenerate = true) val id: Long,

    val title: String,
    val description: String,
    val vibration: Boolean,

    val iconColor: Int,
    val backgroundColor: Int,

    val fastInput: Boolean,
    val addButton: Boolean
)