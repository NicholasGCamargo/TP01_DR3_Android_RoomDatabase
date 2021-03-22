package com.example.tp01_nicholas_camargo_dr3

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp01_nicholas_camargo_dr3.adapter.rcyVwContatosAdapter
import com.example.tp01_nicholas_camargo_dr3.database.AppDatabase
import com.example.tp01_nicholas_camargo_dr3.database.AppDatabaseService
import com.example.tp01_nicholas_camargo_dr3.model.Contato
import com.example.tp01_nicholas_camargo_dr3.model.ContatoETelefone
import com.example.tp01_nicholas_camargo_dr3.model.Telefones
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        criaListaAsync().execute()

        fabAddContato.setOnClickListener {
            startActivity(Intent(this, CriarContatoActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        criaListaAsync().execute()
    }

    inner class criaListaAsync: AsyncTask<
                Unit,
                Unit,
                Array<ContatoETelefone>
            >(){

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(applicationContext, "Carregando seus contatos.", Toast.LENGTH_LONG).show()
        }

        override fun doInBackground(vararg params: Unit?): Array<ContatoETelefone> {
            var appDatabase = AppDatabaseService.getInstance(applicationContext)
            var contatos = appDatabase.contatoDAO().contatoCompleto()

            return contatos!!
        }

        override fun onPostExecute(result: Array<ContatoETelefone>?) {
            super.onPostExecute(result)

            val contatoAdapter = rcyVwContatosAdapter(result!!, applicationContext)
            rcyVwPrimario.adapter = contatoAdapter
            rcyVwPrimario.layoutManager = LinearLayoutManager(applicationContext)

//            contatoAdapter.notifyDataSetChanged()

            rcyVwPrimario.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
        }
    }
}
