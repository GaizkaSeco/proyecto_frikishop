package com.example.frikishop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "figuras")
data class Figura(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull @ColumnInfo (name = "nombre") val nombre: String = "",
    @NonNull @ColumnInfo (name = "dimensiones") val dimensiones: String = "",
    @NonNull @ColumnInfo (name = "coste") val coste: Double = 0.0,
) {
}
