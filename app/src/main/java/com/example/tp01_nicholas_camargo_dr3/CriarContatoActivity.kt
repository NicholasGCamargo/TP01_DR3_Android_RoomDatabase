package com.example.tp01_nicholas_camargo_dr3

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tp01_nicholas_camargo_dr3.database.AppDatabaseService
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.ContatoETelefone
import com.example.tp01_nicholas_camargo_dr3.model.Telefones
import kotlinx.android.synthetic.main.activity_criar_contato.*
import java.lang.Exception

class CriarContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_contato)

        btnCriarConta.setOnClickListener {
            CriaContatoAsync().execute(applicationContext)
        }
    }

    inner class CriaContatoAsync():AsyncTask<Context, Unit, Unit>(){
        override fun doInBackground(vararg params: Context?) {
            try {

                val database = AppDatabaseService.getInstance(params[0]!!)

                val contato = Contato(editTextNome.text.toString(),null)

//                database.contatoETelDAO().store(contato, listOf(telefone1,telefone2))
                database.contatoDAO().store(contato)

                val index = database.contatoDAO().all().lastIndex

                val idContato = database.contatoDAO().all()[index].id_contato

                val telefone1 = Telefones(editTextTipo.text.toString(),
                    editTextNumero.text.toString(),
                    null,
                    idContato)
                val telefone2 = Telefones(editTextTipo2.text.toString(),
                    editTextNumero2.text.toString(),
                    null,
                    idContato)

                database.telefonesDAO().store(telefone1)
                database.telefonesDAO().store(telefone2)

                finish()
            }catch (e: Exception){
                Log.e("DEU RUIM NA DATABASE", e.toString())
            }
        }
    }
}
