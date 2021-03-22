package com.example.tp01_nicholas_camargo_dr3.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
class Contato(
    var nome: String,
    @PrimaryKey(autoGenerate = true)
    var id_contato: Int? = null
) {}
