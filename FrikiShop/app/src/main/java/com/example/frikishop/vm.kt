package com.example.frikishop

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class vm(private val miRepositiorio:Repositorio): ViewModel() {
    val figura: LiveData<List<Figura>> = miRepositiorio.listaFiguras.asLiveData()
    val users: LiveData<List<User>> = miRepositiorio.listaUsers.asLiveData()
    lateinit var existe: LiveData<Int>
    lateinit var guardar: LiveData<Figura>
    lateinit var miUser: LiveData<User>
    lateinit var carrito: MutableList<Figura>

    fun BuscarUser (nombre: String, contrasena: String) = viewModelScope.launch {
        existe= miRepositiorio.BuscarUser(nombre, contrasena).asLiveData()
    }

    fun BuscarFigura (posicion: Int) = viewModelScope.launch {
        guardar= miRepositiorio.BuscarFigura(posicion).asLiveData()
    }

    fun Insertar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Insertar(miUser)
    }

    fun MostrarFiguras () =viewModelScope.launch {
        miRepositiorio.Mostrar()
    }

    fun Borrar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Borrar(miUser)
    }

    fun Actualizar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Actualizar(miUser)
    }

    fun Insertar (miFigura: Figura) = viewModelScope.launch {
        miRepositiorio.Insertar(miFigura)
    }

    fun Borrar (miFigura: Figura) = viewModelScope.launch {
        miRepositiorio.Borrar(miFigura)
    }

    fun Actualizar (miFigura: Figura) = viewModelScope.launch {
        miRepositiorio.Actualizar(miFigura)
    }

    fun Insertar (miPedido: Pedido) = viewModelScope.launch {
        miRepositiorio.Insertar(miPedido)
    }

    fun Borrar (miPedido: Pedido) = viewModelScope.launch {
        miRepositiorio.Borrar(miPedido)
    }

    fun Actualizar (miPedido: Pedido) = viewModelScope.launch {
        miRepositiorio.Actualizar(miPedido)
    }
}


class AppViewModelFactory(private val repositorio: Repositorio ) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(vm::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return vm(repositorio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
