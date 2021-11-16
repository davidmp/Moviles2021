package pe.edu.upeu.appupeunative.ui.persona

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_persona.view.*
import pe.edu.upeu.appupeunative.databinding.PersonaFragmentBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pe.edu.upeu.appupeunative.R
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.modelo.State
import pe.edu.upeu.appupeunative.modelo.User
import pe.edu.upeu.appupeunative.ui.persona.adapter.PersonaListAdapter
import pe.edu.upeu.appupeunative.utils.*


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PersonaFragment : Fragment() {

    companion object {
        fun newInstance() = PersonaFragment()
        const val ANIMATION_DURATION=1000.toLong()
    }
    private var _binding: PersonaFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaViewModel
    private val mAdapter=PersonaListAdapter(this::onItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PersonaFragmentBinding.inflate(inflater, container, false)
        viewModel =ViewModelProvider(this).get(PersonaViewModel::class.java)

        binding.personaRecyclerView.adapter=mAdapter
        val root: View = binding.root

        val nombre=arguments?.get("nombre").toString()

        binding.idMsg.setText(nombre)
        binding.fabPersona.setOnClickListener {
            var user=User()
            viewModel.login(user)
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            findNavController().navigate(R.id.action_personaFragment_to_detallepersonaFragment)
        }

        handleNetworkChanges()
        iniPersonas()
        //return inflater.inflate(R.layout.persona_fragment, container, false)
        return root
    }

    private fun onItemClicked(persona: Persona, /*imageView: ImageView,*/ v:View){
        when(v!!){
            v.itemPersonaBtnDelet->{
                val alertDialog = AlertDialog.Builder(this.requireContext()).create()
                alertDialog.setTitle("Mensaje de Confirmación")
                alertDialog.setMessage("Desea eliminar registro?")
                alertDialog.setButton(
                    AlertDialog.BUTTON_POSITIVE, "Si"
                ) { dialog, which ->
                    deleteProduct(persona)
                    dialog.dismiss() }
                alertDialog.setButton(
                    AlertDialog.BUTTON_NEGATIVE, "No"
                ) { dialog, which -> dialog.dismiss() }
                alertDialog.show()
            }
            else->{
                var data= Bundle()
                data.putString("idData", persona.id)
                findNavController().navigate(R.id.action_detallepersonaFragment_to_personaFragment, data).let { onDestroyView() }
                /*val intent=Intent(this.context, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.PRODUCT_ID,producto.id)
                val options= ActivityOptionsCompat.makeSceneTransitionAnimation(
                this.requireActivity(), imageView, imageView.transitionName
                )
                startActivity(intent, options.toBundle())*/
            }
        }
    }

    private fun handleNetworkChanges(){
        NetworkUtils.getNetworkLiveData(this.requireContext()).observe(this.requireActivity()){
                isConnected->
            if (!isConnected){
                binding.idMsg.text=getString(R.string.text_no_connectivity)
                binding.estadoRedconeccion.apply {
                    show()
                    setBackgroundColor(getColorRes(R.color.colorStatusNotConnected))
                }
            }else{
            //if (viewModel.personasLidaData.value is State.Error || mAdapter.itemCount==0 ){
                getPersonas()
            //}
                binding.idMsg.text=getString(R.string.text_connectivity)
                binding.estadoRedconeccion.apply {
                    setBackgroundColor(getColorRes(R.color.colorStatusConnected))
                    animate().alpha(1f)
                        .setStartDelay(PersonaFragment.ANIMATION_DURATION)
                        .setDuration(PersonaFragment.ANIMATION_DURATION)
                        .setListener(object : AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator?) {
                                hide()
                            }
                        })
                }
            }
        }
    }

    private fun iniPersonas(){
        viewModel.personasLidaData.observe(this.requireActivity()){
                state->
            when(state){
                is State.Loading->showLoading(true)
                is State.Success->{
                    if (state.data.isNotEmpty()){
                        mAdapter.submitList(state.data.toMutableList())
                        showLoading(false)
                    }
                }
                is State.Error->{
                    showToast(state.message)
                    showLoading(false)
                }
            }
        }
        binding.swipeRefreshLayout.setOnRefreshListener { getPersonas() }
        if (viewModel.personasLidaData.value !is State.Success){
            getPersonas()
        }
    }

    private fun getPersonas(){
        viewModel.getPersonas()
    }

    private fun deleteProduct(persona: Persona){
       viewModel.deleteProductById(persona)
    }

    private fun showLoading(isLoading:Boolean){
        binding.swipeRefreshLayout.isRefreshing=isLoading
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}