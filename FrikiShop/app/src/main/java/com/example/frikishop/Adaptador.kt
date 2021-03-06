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

class Adaptador(var fragmento: Fragment, var figuras: List<Figura>, var actividad: MainActivity): RecyclerView.Adapter<Adaptador.ViewHolder>() {
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var textNombre: TextView
        var textCoste: TextView
        var textDiametro: TextView
        var posicion:Int =-1
        var buttonAnadir: Button
        init{
            textNombre = v.findViewById(R.id.textNombre)
            textCoste = v.findViewById(R.id.textCoste)
            textDiametro = v.findViewById(R.id.textDiametro)
            buttonAnadir = v.findViewById(R.id.buttonAnadir)
            buttonAnadir.setOnClickListener() {
                actividad.miViewModel.BuscarFigura(posicion)
                actividad.miViewModel.guardar.observe(actividad){
                    actividad.miViewModel.carrito.add(it)
                    Toast.makeText(
                        actividad,
                        "Añadido correctamente al carro",
                        Toast.LENGTH_SHORT
                    ).show()
                }
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
