package com.mrlorx.fixcalc

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "items",
    foreignKeys = [
        ForeignKey(
            entity = Screen::class,
            parentColumns = ["id"],
            childColumns = ["screenId"],
            onDelete = CASCADE
        )
    ]
)

data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long,

    val name: String,
    val color: Int,
    val value: Float,
    val discount_percent: Boolean,
    val screenId: Long
)