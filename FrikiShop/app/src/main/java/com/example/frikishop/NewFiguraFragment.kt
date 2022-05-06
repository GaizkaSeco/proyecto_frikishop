package com.example.frikishop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentNewFiguraBinding
import com.example.frikishop.databinding.FragmentNewUserBinding

class NewFiguraFragment : Fragment() {
    private var _binding: FragmentNewFiguraBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewFiguraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.anadirFigura.setOnClickListener {
            if (binding.nombreFigura.text.isNotEmpty() && binding.dimensiones.text.isNotEmpty() && binding.coste.text.isNotEmpty()) {
                val figura = Figura(nombre=binding.nombreFigura.text.toString(), dimensiones= binding.dimensiones.text.toString(), coste=binding.coste.text.toString().toDouble())
                (activity as MainActivity).vm.Insertar(figura)
                Toast.makeText(activity, "Añadido Correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_newFiguraFragment_to_FirstFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}