package com.example.tp01_nicholas_camargo_dr3.dao

import androidx.room.*
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.ContatoETelefone

@Dao
interface contatoDAO {
    @Insert fun store(contato: Contato)
    @Update fun update(contato: Contato)

    @Transaction
    @Delete fun delete(contato: Contato)

    @Query("SELECT * FROM Contato")
    fun all(): Array<Contato>
    @Query("SELECT * FROM Contato WHERE id_contato = :indicador")
    fun show(indicador: Int): Array<Contato>

    @Transaction
    @Query("SELECT * FROM Contato WHERE id_contato = :indicador")
    fun showCompleto(indicador: Int): Array<ContatoETelefone>

    @Transaction
    @Query("SELECT * FROM Contato")
    fun contatoCompleto(): Array<ContatoETelefone>
}