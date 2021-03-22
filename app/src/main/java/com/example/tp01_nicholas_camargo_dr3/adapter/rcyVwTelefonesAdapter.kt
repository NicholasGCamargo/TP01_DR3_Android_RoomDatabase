package com.example.tp01_nicholas_camargo_dr3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp01_nicholas_camargo_dr3.R
import com.example.tp01_nicholas_camargo_dr3.model.Telefones
import kotlinx.android.synthetic.main.rcy_vw_layout_interno.view.*

class rcyVwTelefonesAdapter(private val lista: List<Telefones>): RecyclerView.Adapter<rcyVwTelefonesAdapter.TelefonesViewHolder>() {

    class TelefonesViewHolder(view: View):RecyclerView.ViewHolder(view){
        val campoTipo = view.txtVwTipoTel
        val campoTel = view.txtVwNumeroTel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonesViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.rcy_vw_layout_interno,
                parent,false
            )
        val holder = TelefonesViewHolder(v)
        return holder
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: TelefonesViewHolder, position: Int) {
        val telefone = lista[position]
        holder.campoTel.text = telefone.telefone
        holder.campoTipo.text = telefone.tipo
    }
}