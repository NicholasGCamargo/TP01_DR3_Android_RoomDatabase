package com.example.tp01_nicholas_camargo_dr3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp01_nicholas_camargo_dr3.dao.contatoDAO
import com.example.tp01_nicholas_camargo_dr3.dao.contatoETelDAO
import com.example.tp01_nicholas_camargo_dr3.dao.telefonesDAO
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.Telefones

@Database(
    entities = arrayOf(
        Contato::class,
        Telefones::class
    ),
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contatoDAO(): contatoDAO
    abstract fun telefonesDAO(): telefonesDAO
    abstract fun contatoETelDAO(): contatoETelDAO
}