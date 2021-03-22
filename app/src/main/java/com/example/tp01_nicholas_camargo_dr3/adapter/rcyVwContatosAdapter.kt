package com.example.tp01_nicholas_camargo_dr3.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp01_nicholas_camargo_dr3.EditarContatoActivity
import com.example.tp01_nicholas_camargo_dr3.R
import com.example.tp01_nicholas_camargo_dr3.database.AppDatabase
import com.example.tp01_nicholas_camargo_dr3.model.ContatoETelefone
import kotlinx.android.synthetic.main.rcy_vw_layout.view.*

class rcyVwContatosAdapter(private val lista: Array<ContatoETelefone>,
                           private val context: Context):
    RecyclerView.Adapter<rcyVwContatosAdapter.ContatosViewHolder>() {
    class ContatosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val campoNome = view.txtVwNome
        val campoVw = view.rcyVwSecundario
        val campoView = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.rcy_vw_layout,
                parent,false
            )
        val contatoViewHolder = ContatosViewHolder(v)


        return contatoViewHolder
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        val contato = lista[position]
        holder.campoNome.text = contato.contato.nome
        val vwSecundaria = holder.campoVw
        var contatoAdapter = rcyVwTelefonesAdapter(contato.telefones)
        vwSecundaria.adapter = contatoAdapter
        vwSecundaria.layoutManager = LinearLayoutManager(context)

        holder.campoView.setOnClickListener {
            val intent = Intent(context, EditarContatoActivity::class.java)
            intent.putExtra("idmagico", contato.contato.id_contato.toString())

            context.startActivity(intent)
        }
    }
}