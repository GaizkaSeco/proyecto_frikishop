package com.example.frikishop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Figura::class), version = 1, exportSchema = false)
abstract class BaseDatos: RoomDatabase() {
    abstract fun miDao(): DaoAplicacion

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos?=null

        fun getDatabase(context: Context): BaseDatos {
            return INSTANCE ?: synchronized(this) {
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "shop_database"
                ).build()
                INSTANCE = instace
                instace
            }
        }
    }
}