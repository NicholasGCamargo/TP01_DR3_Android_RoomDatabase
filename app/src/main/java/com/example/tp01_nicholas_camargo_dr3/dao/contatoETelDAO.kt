package com.example.tp01_nicholas_camargo_dr3.dao

import androidx.room.*
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.ContatoETelefone
import com.example.tp01_nicholas_camargo_dr3.model.Telefones


//Completamente inutil, feito para testes
@Dao
interface contatoETelDAO {
    @Insert
    fun store(contato: Contato, tel: List<Telefones>)
    @Update
    fun update(contato: Contato, tel: List<Telefones>)
    @Delete
    fun delete(contato: Contato, tel: List<Telefones>)

    @Transaction
    @Query("SELECT * FROM Contato, Telefones WHERE Contato.id_contato = Telefones.id_tel_fk")
    fun all(): Array<ContatoETelefone>
}