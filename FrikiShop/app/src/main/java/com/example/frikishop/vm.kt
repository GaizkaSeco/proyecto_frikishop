package com.example.frikishop

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class vm(private val miRepositiorio:Repositorio): ViewModel() {
    val users: LiveData<List<User>> = miRepositiorio.listaUsers.asLiveData()
    lateinit var miUser: LiveData<User>

    fun Insertar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Insertar(miUser)
    }

    fun Borrar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Borrar(miUser)
    }

    fun Actualizar (miUser: User) = viewModelScope.launch {
        miRepositiorio.Actualizar(miUser)
    }
}

class CineViewModelFactory(private val repositorio: Repositorio ) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(vm::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return vm(repositorio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
