package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frikishop.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var miRecyclerView: RecyclerView
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var misFiguras: List<Figura> = listOf()


        miRecyclerView = binding.recyclerView
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        (activity as MainActivity).miViewModel.MostrarFiguras()
        (activity as MainActivity).miViewModel.figura.observe(activity as MainActivity)
        { Figura ->
            Figura?.let {
                Log.d("figuras",it.size.toString())
                misFiguras = it
                miRecyclerView.adapter = Adaptador(this, misFiguras, (activity as MainActivity))
            }
        }
        binding.botonVolver.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.botonCarrito.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_carritoFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.new_figura)?.isVisible=false
        menu.findItem(R.id.new_user)?.isVisible=false
    }
}