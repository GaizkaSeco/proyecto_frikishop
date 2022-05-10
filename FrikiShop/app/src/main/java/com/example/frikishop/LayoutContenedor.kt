package com.example.frikishop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentLayoutContenedorBinding

class LayoutContenedor : Fragment() {

    private var _binding: FragmentLayoutContenedorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLayoutContenedorBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setHasOptionsMenu(true)

        /*binding.NewButton.setOnClickListener {
            if (binding.NombreEdit.text.isNotEmpty() && binding.FechaEdit.text.isNotEmpty() && binding.CategoriaEdit.text.isNotEmpty()) {
                val peli = Pelicula(nombre=binding.NombreEdit.text.toString(), fecha=binding.FechaEdit.text.toString(), genero=binding.CategoriaEdit.text.toString())
                (activity as MainActivity).vm.Insertar(peli)
                Toast.makeText(activity, "Añadido Correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_show_to_SecondFragment)
            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.new_pelicula)?.isVisible=false
        menu.findItem(R.id.action_settings)?.isVisible=true
    }*/
}