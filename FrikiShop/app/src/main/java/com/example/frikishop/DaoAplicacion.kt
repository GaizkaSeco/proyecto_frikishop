package com.example.frikishop

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoAplicacion {
    @Query("SELECT * FROM figuras ORDER BY nombre ASC")
    fun MostrarFiguras(): Flow<List<Figura>>

    @Query("SELECT * FROM figuras WHERE id LIKE :id")
    fun BuscarFigura(id: Int): Flow<Figura>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertFigura(word: Figura)

    @Update
    suspend fun ActualizarFigura(word: Figura)

    @Delete
    suspend fun BorrarFigura(word: Figura)

    @Query("SELECT * FROM tabla_users ORDER BY nombre ASC")
    fun MostrarUsers(): Flow<List<User>>

    @Query("SELECT * FROM tabla_users WHERE nombre LIKE :nombre AND contrasena LIKE :contrasena")
    fun BuscarUser(nombre: String, contrasena: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertUser(word: User)

    @Update
    suspend fun ActualizarUser(word: User)

    @Delete
    suspend fun BorrarUser(word: User)

    @Query("SELECT * FROM tabla_pedidos ORDER BY id ASC")
    fun MostrarPedidos(): Flow<List<Pedido>>

    @Query("SELECT * FROM tabla_pedidos WHERE id LIKE :id")
    fun BuscarPedido(id: Int): Flow<Pedido>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertPedido(word: Pedido)

    @Update
    suspend fun ActualizarPedido(word: Pedido)

    @Delete
    suspend fun BorrarPedido(word: Pedido)

}