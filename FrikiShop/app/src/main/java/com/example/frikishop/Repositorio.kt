package com.example.frikishop

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class Repositorio(val miDao: DaoAplicacion) {
    val listaUsers: Flow<List<User>> = miDao.MostrarUsers()
    val listaPedidos: Flow<List<Pedido>> = miDao.MostrarPedidos()
    val listaFiguras: Flow<List<Figura>> = miDao.MostrarFiguras()

    suspend fun Mostrar() {
        miDao.MostrarFiguras()
    }

    fun BuscarUser(nombre: String, contrasena: String):Flow<Int> {
        return miDao.BuscarUser(nombre, contrasena)
    }

    fun BuscarLoggin(id: Int): Flow<User> {
        return miDao.BuscarLoggin(id)
    }

    fun BuscarFigura(posicion: Int): Flow<Figura> {
        return miDao.BuscarFigura(posicion)
    }

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