package com.generation.sqlroom.data

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    // metodo abstrato pra retornar a interface e ter acesso as requisições
    abstract fun userDao(): UserDao

    //retornar o databse pra main view model e processar tudo que precisa
    companion object {
        //certifica que n existe nenhuma instancia do Room ja criada
        @Volatile //fique visivel a todas as treads do aplicativo quando for instanciada
        private var INSTANCE: UserDatabase? = null

        //checa se ja assiste e se n ter, criar uma
        //context pq precisa do context onde ta sendo criado
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            //se ja existir retorna ela
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}