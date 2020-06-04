package com.example.edifikarmobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edifikarmobileapp.R
import com.example.edifikarmobileapp.model.ListaProyecto
import com.example.edifikarmobileapp.model.Proyect
import kotlinx.android.synthetic.main.prototype_proyects.view.*

class ProyectAdapter(val proyects: List<ListaProyecto>): RecyclerView.Adapter<ProyectPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProyectPrototype {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.prototype_proyects,parent,false)
        return ProyectPrototype(view)
    }

    override fun getItemCount(): Int {
        return proyects.size
    }

    override fun onBindViewHolder(holder: ProyectPrototype, position: Int) {
        holder.bind(proyects[position])
    }
}

class ProyectPrototype (itemView: View) : RecyclerView.ViewHolder(itemView){
    val ivphoto = itemView.ivPhoto1
    val ivLogo = itemView.ivLogo
    val tvName = itemView.tvName
    val tvUbicacion = itemView.tvUbicacion

    fun bind (proyect: ListaProyecto){
       /* Glide.with(itemView).load(proyect.photo).into(ivphoto)
        Glide.with(itemView).load(proyect.logo).into(ivLogo)*/
        tvName.text = proyect.nombreProyecto
        //tvUbicacion.text = proyect.ubicacion
    }
}
