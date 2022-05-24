package com.example.frikishop

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("error", "fragmento si")
        setHasOptionsMenu(true)
        binding.tvBienvenida.text = "Bienvenid@ " + (activity as MainActivity).miViewModel.logedo.nombre

        binding.botonComprar.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.botonPopulares.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        when (item.itemId) {
            R.id.new_figura -> findNavController().navigate(R.id.action_FirstFragment_to_newFiguraFragment)
            R.id.new_user -> findNavController().navigate(R.id.action_FirstFragment_to_newUserFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        Log.d("permiso_usuario",(activity as MainActivity).miViewModel.logedo.rol )
        if ((activity as MainActivity).miViewModel.logedo.rol == "Admin") {
            menu.findItem(R.id.new_figura)?.isVisible = true
            menu.findItem(R.id.new_user)?.isVisible = true
        } else {
            menu.findItem(R.id.new_figura)?.isVisible = false
            menu.findItem(R.id.new_user)?.isVisible = false
        }
    }
}