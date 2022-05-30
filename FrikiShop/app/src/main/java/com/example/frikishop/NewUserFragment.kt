package com.example.frikishop

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
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
        setHasOptionsMenu(true)

        binding.botonAnadir.setOnClickListener {
            if (binding.userName.text.isNotEmpty() && binding.contrasena.text.isNotEmpty() && binding.rol.text.isNotEmpty()) {
                Log.d("permiso_usuario",binding.rol.text.toString())
                val user = User(nombre=binding.userName.text.toString(), contrasena= binding.contrasena.text.toString(), rol=binding.rol.text.toString())
                (activity as MainActivity).miViewModel.Insertar(user)
                Toast.makeText(activity, "Añadido Correctamente", Toast.LENGTH_SHORT).show()
                Log.d("error", "Aque si")
                findNavController().navigate(R.id.action_newUserFragment_to_FirstFragment)

            }
        }

        binding.botonVerUsuarios.setOnClickListener {
            findNavController().navigate(R.id.action_newUserFragment_to_mostrarUsersFragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.new_user -> findNavController().navigate(R.id.action_FirstFragment_to_newUserFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
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