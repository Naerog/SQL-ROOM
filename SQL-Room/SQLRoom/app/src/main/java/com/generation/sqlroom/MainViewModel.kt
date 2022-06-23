package com.generation.sqlroom

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.sqlroom.data.UserDatabase
import com.generation.sqlroom.data.UserRepository
import com.generation.sqlroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//fazendo isso aq vc faz ele n precsar se importar com o contexto especifico com o negocio do application
class MainViewModel(application: Application) : ViewModel() {
    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        //aq cria um objeto que seja um userDao
        val userDao = UserDatabase.getDatabase(application).userDao()
        // com essa n precisamos mais fazer injeção de dependencia com activity ou fragment
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
        // por meio dela usa o repositorio e pega todos os dados do banco
    }
    fun addUser(usuario: Usuario) {
        //colocar dentro de uma corrotina
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(usuario)
        }
    }
}