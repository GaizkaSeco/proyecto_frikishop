package com.example.frikishop

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio(val miDao: DaoAplicacion) {
    val listaUsers: Flow<List<User>> = miDao.MostrarUsers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miUser: User) {
        miDao.InsertUser(miUser)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miUser: User) {
        miDao.BorrarUser(miUser)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miUser: User) {
        miDao.ActualizarUser(miUser)
    }
}