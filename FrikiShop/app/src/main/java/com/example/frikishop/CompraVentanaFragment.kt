package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentCompraVentanaBinding
import com.example.frikishop.databinding.FragmentNewUserBinding

class CompraVentanaFragment : Fragment() {
    private var _binding: FragmentCompraVentanaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compra_ventana, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonComprar.setOnClickListener {
            if (binding.tvNombre.text.isNotEmpty() && binding.numeroTargeta.text.isNotEmpty() && binding.fechaTargeta.text.isNotEmpty() && binding.csvTargeta.text.isNotEmpty()) {
                //anadir el pedido y terminado.
            }
        }
    }
}