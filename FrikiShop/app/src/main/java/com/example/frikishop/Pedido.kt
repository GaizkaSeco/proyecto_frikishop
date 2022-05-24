package com.example.frikishop

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_pedidos")
data class Pedido(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull @ColumnInfo(name = "total") var total: String = "",
    @NonNull @ColumnInfo (name = "titular") var titular: String = "",
    @NonNull @ColumnInfo (name = "tarjeta") var tarjeta: String = "",
    @NonNull @ColumnInfo (name = "ccv") var ccv: Int = 0,
    @NonNull @ColumnInfo (name = "fecha_caducidad") var fecha_caducidad: String = "",
){}
