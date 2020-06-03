package com.example.edifikarmobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edifikarmobileapp.R
import com.example.edifikarmobileapp.model.Proyect
import kotlinx.android.synthetic.main.prototype_proyects.view.*

class ProyectAdapter(val proyects: List<Proyect>): RecyclerView.Adapter<ProyectPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProyectPrototype {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.activity_proyect,parent,false)
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

    fun bind (proyect: Proyect){
        Glide.with(itemView).load(proyect.photo).into(ivphoto)
        Glide.with(itemView).load(proyect.logo).into(ivLogo)
        tvName.text = proyect.name
        tvUbicacion.text = proyect.ubicacion
    }
}
