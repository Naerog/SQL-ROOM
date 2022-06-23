package com.generation.sqlroom.data

class UserRepository(private val userDao: UserDao) {
    //por meio do userDao pega o selectUsers, dessa forma ele vai conseguir
    //retornar um live data de list usuario
    val selectUsers = userDao.selectUsers()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }
    // com isso aq feito ele consegue se comunicar com o banco e fazer
    // as requisições necessárias
}