package com.example.frikishop

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class AdaptadorListaFiguras(var fragmento: Fragment, var figuras: List<Figura>, var actividad: MainActivity): RecyclerView.Adapter<AdaptadorListaFiguras.ViewHolder>() {
    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        var textNombre: TextView
        var textDiametro: TextView
        var textCoste: TextView
        var posicion:Int =-1
        init{
            textNombre = v.findViewById(R.id.textNombre)
            textDiametro = v.findViewById(R.id.textDiame)
            textCoste = v.findViewById(R.id.textCost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.fragment_layout_lista_figuras_contenedor, parent, false)
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