package com.example.frikishop

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class AdaptadorListaUsers(var fragmento: Fragment, var users: List<User>, var actividad: MainActivity): RecyclerView.Adapter<AdaptadorListaUsers.ViewHolder>() {
    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        var textNombre: TextView
        var textContrasena: TextView
        var textRol: TextView
        var posicion:Int =-1
        init{
            textNombre = v.findViewById(R.id.textNombre)
            textContrasena = v.findViewById(R.id.textContrasena)
            textRol = v.findViewById(R.id.textRol)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.fragment_layout_contenedor_usuarios, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("figuras",users[position].nombre)
        holder.textNombre.text=users[position].nombre
        holder.textContrasena.text=users[position].contrasena
        holder.textRol.text=users[position].rol
        holder.posicion=users[position].id
    }

    override fun getItemCount(): Int {
        return users.size
    }
}