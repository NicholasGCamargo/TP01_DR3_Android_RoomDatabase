package com.example.tp01_nicholas_camargo_dr3.model

import androidx.room.*

data class ContatoETelefone(
    @Embedded val contato: Contato,
    @Relation(
        parentColumn = "id_contato",
        entityColumn = "id_tel_fk"
    )
    val telefones: List<Telefones>
) {}