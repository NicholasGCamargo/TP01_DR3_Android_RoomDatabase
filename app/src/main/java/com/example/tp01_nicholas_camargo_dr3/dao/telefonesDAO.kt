package com.example.tp01_nicholas_camargo_dr3.dao

import androidx.room.*
import com.example.tp01_nicholas_camargo_dr3.model.Telefones


@Dao
interface telefonesDAO {
    @Insert
    fun store(telefones: Telefones)
    @Update
    fun update(telefones: Telefones)
    @Delete
    fun delete(telefones: Telefones)

    @Query("SELECT * FROM Telefones")
    fun all(): Array<Telefones>

    @Query("SELECT * FROM Telefones WHERE id_tel_fk = :indicador_fk")
    fun show(indicador_fk: Int): Array<Telefones>
}