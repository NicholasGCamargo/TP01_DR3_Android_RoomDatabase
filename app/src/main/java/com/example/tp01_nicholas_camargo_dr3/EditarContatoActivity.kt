package com.example.tp01_nicholas_camargo_dr3

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tp01_nicholas_camargo_dr3.database.AppDatabaseService
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.Telefones
import kotlinx.android.synthetic.main.activity_editar_contato.*

class EditarContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_contato)

        val idMagico = intent.getStringExtra("idmagico")

        conectarBDAsync().execute("CONECTAR", idMagico.toString())

        btnEditarContato.setOnClickListener {
            conectarBDAsync().execute("EDITAR", idMagico.toString())
        }

        btnExcluirContato.setOnClickListener {
            conectarBDAsync().execute("DELETAR", idMagico.toString())
        }
    }

    inner class conectarBDAsync:AsyncTask<String, Unit, Unit>(){
        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(
                applicationContext,
                "Carregando os dados.",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun doInBackground(vararg params: String?) {
            when(params[0]){
                "EDITAR" ->{
                    val appDatabase = AppDatabaseService.getInstance(applicationContext)
                    val contato = appDatabase.contatoDAO().show(params[1]!!.toInt())

                    val novoContato = Contato(editTextNomeEditar.text.toString(), contato[0].id_contato)
                    appDatabase.contatoDAO().update(novoContato)

                    val telefones = appDatabase.telefonesDAO().show(params[1]!!.toInt())
                    val novoTelefone1=
                        Telefones(
                            editTextTipo1Editar.text.toString(),
                            editTextTel1Editar.text.toString(),
                            telefones[0].id_tel,
                            telefones[0].id_tel_fk
                            )
                    val novoTelefone2 =
                        Telefones(
                            editTextTipo2Editar.text.toString(),
                            editTextTel2Editar.text.toString(),
                            telefones[1].id_tel,
                            telefones[1].id_tel_fk
                        )

                    appDatabase.telefonesDAO().update(novoTelefone1)
                    appDatabase.telefonesDAO().update(novoTelefone2)

                    finish()
                }

                "DELETAR" ->{
                    val appDatabase = AppDatabaseService.getInstance(applicationContext)
                    val contato = appDatabase.contatoDAO().show(params[1]!!.toInt())

                    appDatabase.contatoDAO().delete(contato[0])

                    val telefones = appDatabase.telefonesDAO().show(params[1]!!.toInt())
                    appDatabase.telefonesDAO().delete(telefones[0])
                    appDatabase.telefonesDAO().delete(telefones[1])

                    finish()
                }

                "CONECTAR" ->{
                    val appDatabase = AppDatabaseService.getInstance(applicationContext)
                    val contato = appDatabase.contatoDAO().showCompleto(params[1]!!.toInt())

                    editTextNomeEditar.setText(contato[0].contato.nome)
                    editTextTipo1Editar.setText(contato[0].telefones[0].tipo!!)
                    editTextTipo2Editar.setText(contato[0].telefones[1].tipo!!)
                    editTextTel1Editar.setText(contato[0].telefones[0].telefone!!)
                    editTextTel2Editar.setText(contato[0].telefones[1].telefone!!)
                }
            }
        }
    }
}
