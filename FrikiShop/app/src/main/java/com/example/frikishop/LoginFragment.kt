package com.example.frikishop

import android.os.Bundle
import android.security.keystore.UserPresenceUnavailableException
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frikishop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        binding.botonIniciar.setOnClickListener {
            val usuarios = (activity as MainActivity).miViewModel.users

            findNavController().navigate(R.id.action_loginFragment2_to_FirstFragment)


            Toast.makeText(activity, "ERROR contraseña o usuario incorrecto.", Toast.LENGTH_SHORT).show()
        }
    }

}