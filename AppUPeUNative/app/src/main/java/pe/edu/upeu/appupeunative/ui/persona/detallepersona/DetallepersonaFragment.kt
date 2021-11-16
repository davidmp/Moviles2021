package pe.edu.upeu.appupeunative.ui.persona.detallepersona

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pe.edu.upeu.appmultiselect.SearchableItem
import pe.edu.upeu.appupeunative.R
import pe.edu.upeu.appupeunative.databinding.DetallepersonaFragmentBinding
import pe.edu.upeu.appupeunative.modelo.Persona

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetallepersonaFragment : Fragment() {

    companion object {
        fun newInstance() = DetallepersonaFragment()
    }

    private lateinit var viewModel: DetallepersonaViewModel
    private var _binding: DetallepersonaFragmentBinding? = null
    private val binding get() = _binding!!

    private var items: MutableList<SearchableItem> = ArrayList()
    var persona=Persona()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detallepersona_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetallepersonaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}