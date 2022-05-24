package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentCarritoBinding
import com.example.frikishop.databinding.FragmentCompraVentanaBinding
import com.example.frikishop.databinding.FragmentNewUserBinding

class CompraVentanaFragment : Fragment() {
    private var _binding: FragmentCompraVentanaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompraVentanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonComprar.setOnClickListener {
            if (binding.tvNombre.text.isNotEmpty() && binding.numeroTarjeta.text.isNotEmpty() && binding.fechaTarjeta.text.isNotEmpty() && binding.ccvTargeta.text.isNotEmpty()) {
                val pedido = Pedido(total = "0", titular = binding.tvNombre.text.toString(), tarjeta = binding.numeroTarjeta.text.toString(), ccv = binding.ccvTargeta.text.toString().toInt(), fecha_caducidad = binding.fechaTarjeta.text.toString())
                (activity as MainActivity).miViewModel.Insertar(pedido)
                Toast.makeText(activity, "Añadido Correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_compraVentanaFragment_to_FirstFragment)
            }
        }
    }
}