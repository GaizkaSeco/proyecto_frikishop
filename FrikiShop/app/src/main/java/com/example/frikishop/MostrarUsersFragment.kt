package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frikishop.databinding.FragmentCarritoBinding
import com.example.frikishop.databinding.FragmentComprarBinding
import com.example.frikishop.databinding.FragmentMostrarUsersBinding

class MostrarUsersFragment : Fragment() {
    lateinit var miRecyclerView: RecyclerView
    private var _binding: FragmentMostrarUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMostrarUsersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var misUsers: List<User> = listOf()

        miRecyclerView = binding.recyclerView2
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        (activity as MainActivity).miViewModel.MostrarFiguras()
        (activity as MainActivity).miViewModel.users.observe(activity as MainActivity)
        { User ->
            User?.let {
                Log.d("user",it.size.toString())
                misUsers = it
                miRecyclerView.adapter = AdaptadorListaUsers(this, misUsers, activity as MainActivity)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}