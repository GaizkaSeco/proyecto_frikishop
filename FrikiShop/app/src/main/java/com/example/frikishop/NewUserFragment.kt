package com.example.frikishop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentFirstBinding
import com.example.frikishop.databinding.FragmentNewUserBinding

class NewUserFragment : Fragment() {
    private var _binding: FragmentNewUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonAnadir.setOnClickListener {
            if (binding.userName.text.isNotEmpty() && binding.contrasena.text.isNotEmpty() && binding.rol.text.isNotEmpty()) {
                val user = User(nombre=binding.userName.text.toString(), contrasena= binding.contrasena.text.toString(), rol=binding.rol.text.toString())
                (activity as MainActivity).miViewModel.Insertar(user)
                Toast.makeText(activity, "Añadido Correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_newUserFragment_to_FirstFragment)
                (activity as MainActivity).miViewModel.users.observe(activity as MainActivity) {
                    Log.d("Usuarios", it.size.toString())
                }
            }
        }

        binding.botonVerUsuarios.setOnClickListener {
            findNavController().navigate(R.id.action_newUserFragment_to_mostrarUsersFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}