package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frikishop.databinding.FragmentCarritoBinding
import com.example.frikishop.databinding.FragmentComprarBinding

class CarritoFragment : Fragment() {
    lateinit var miRecyclerView: RecyclerView
    private var _binding: FragmentCarritoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCarritoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        miRecyclerView = binding.recycleView
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        miRecyclerView.adapter = AdaptadorCarrito(this, (activity as MainActivity).miViewModel.carrito, activity as MainActivity)

        binding.buttonPagar.setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_compraVentanaFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}