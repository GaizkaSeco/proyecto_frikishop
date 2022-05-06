package com.example.frikishop

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio(val miDao: DaoAplicacion) {
    val listaUsers: Flow<List<User>> = miDao.MostrarUsers()
    val listaPedidos: Flow<List<Pedido>> = miDao.MostrarPedidos()
    val listaFiguras: Flow<List<Figura>> = miDao.MostrarFiguras()

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

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miPedido: Pedido) {
        miDao.InsertPedido(miPedido)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miPedido: Pedido) {
        miDao.BorrarPedido(miPedido)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miPedido: Pedido) {
        miDao.ActualizarPedido(miPedido)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miFigura: Figura) {
        miDao.InsertFigura(miFigura)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miFigura: Figura) {
        miDao.BorrarFigura(miFigura)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miFigura: Figura) {
        miDao.ActualizarFigura(miFigura)
    }
}