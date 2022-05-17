package com.example.frikishop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var fragmento: Fragment, var figuras: List<Figura>): RecyclerView.Adapter<Adaptador.ViewHolder>() {
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var textNombre: TextView
        var textCoste: TextView
        var textDiametro: TextView
        var posicion:Int =-1
        init{
            textNombre = v.findViewById(R.id.textNombre)
            textCoste = v.findViewById(R.id.textCoste)
            textDiametro = v.findViewById(R.id.textDiametro)
            v.setOnClickListener() {
                var bundle: Bundle = bundleOf("id" to posicion)
                fragmento.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.fragment_layout_contenedor, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("figuras",figuras[position].nombre)
        holder.textNombre.text=figuras[position].nombre
        holder.textDiametro.text=figuras[position].dimensiones
        holder.textCoste.text=figuras[position].coste.toString()
        holder.posicion=figuras[position].id
    }

    override fun getItemCount(): Int {
        return figuras.size
    }
}
