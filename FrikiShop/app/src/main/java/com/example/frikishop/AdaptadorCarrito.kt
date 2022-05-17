package com.example.frikishop

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCarrito(var fragmento: Fragment, var carrito: List<Figura>, var actividad: MainActivity): RecyclerView.Adapter<AdaptadorCarrito.ViewHolder>() {
    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        var textNombre: TextView
        var textCoste: TextView
        var textDiametro: TextView
        var posicion:Int =-1
        init{
            textNombre = v.findViewById(R.id.textNombre)
            textCoste = v.findViewById(R.id.textCoste)
            textDiametro = v.findViewById(R.id.textDiametro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.fragment_layout_contenedor_carrito, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("figuras",carrito[position].nombre)
        holder.textNombre.text=carrito[position].nombre
        holder.textDiametro.text=carrito[position].dimensiones
        holder.textCoste.text=carrito[position].coste.toString()
        holder.posicion=carrito[position].id
    }

    override fun getItemCount(): Int {
        return carrito.size
    }
}