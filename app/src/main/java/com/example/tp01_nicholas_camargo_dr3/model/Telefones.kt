package com.example.tp01_nicholas_camargo_dr3.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
class Telefones(
    var tipo: String,
    var telefone: String,
    @PrimaryKey(autoGenerate = true)
    var id_tel: Int? = null,
    @ForeignKey(entity = Contato::class, onDelete = ForeignKey.CASCADE,parentColumns = arrayOf("id_contato"), childColumns = arrayOf("id_tel_fk"))
    var id_tel_fk: Int? = null
) {

}
