package com.example.frikishop

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comprar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var misFiguras: List<Figura> = listOf()

        miRecyclerView = binding.recyclerView2
        miRecyclerView.layoutManager= LinearLayoutManager(activity)
        (activity as MainActivity).miViewModel.figura.observe(activity as MainActivity) { Figura -> Figura?.let { misFiguras = it
            miRecyclerView.adapter=Adaptador(this, misFiguras)}}

    }
}