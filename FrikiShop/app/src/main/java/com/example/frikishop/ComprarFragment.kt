package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frikishop.databinding.FragmentComprarBinding

class ComprarFragment : Fragment() {
    lateinit var miRecyclerView: RecyclerView
    private var _binding: FragmentComprarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentComprarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var misFiguras: List<Figura> = listOf()


        miRecyclerView = binding.recyclerView2
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        (activity as MainActivity).miViewModel.MostrarFiguras()
        (activity as MainActivity).miViewModel.figura.observe(activity as MainActivity)
        { Figura ->
            Figura?.let {
                Log.d("figuras",it.size.toString())
                misFiguras = it
                miRecyclerView.adapter = AdaptadorCarrito(this, misFiguras, activity as MainActivity)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
