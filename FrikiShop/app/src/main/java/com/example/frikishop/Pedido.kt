package com.example.frikishop

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_pedidos")
data class Pedido(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull @ColumnInfo(name = "total") var total: String = "",
    @NonNull @ColumnInfo (name = "comprador") var comprador: String = ""
){}
