package pe.edu.upeu.appupeunative.ui.persona

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pe.edu.upeu.appupeunative.R
import pe.edu.upeu.appupeunative.databinding.FragmentHomeBinding
import pe.edu.upeu.appupeunative.databinding.PersonaFragmentBinding

class PersonaFragment : Fragment() {

    companion object {
        fun newInstance() = PersonaFragment()
    }
    private var _binding: PersonaFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PersonaFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val nombre=arguments?.get("nombre").toString()

        binding.idMsg.setText(nombre)
        binding.buttonIdReturn.setOnClickListener {
            findNavController().navigate(R.id.action_personaFragment_to_nav_home)
        }

        binding.buttonIdNext.setOnClickListener {
            findNavController().navigate(R.id.action_personaFragment_to_nav_gallery)
        }
        //return inflater.inflate(R.layout.persona_fragment, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}