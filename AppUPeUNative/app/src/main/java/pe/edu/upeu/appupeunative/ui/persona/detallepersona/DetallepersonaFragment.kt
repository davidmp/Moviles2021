package pe.edu.upeu.appupeunative.ui.persona.detallepersona

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detallepersona_fragment.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pe.edu.upeu.appmultiselect.SearchableItem
import pe.edu.upeu.appmultiselect.SearchableSingleSelectSpinner
import pe.edu.upeu.appmultiselect.SingleSelectionCompleteListener
import pe.edu.upeu.appupeunative.R
import pe.edu.upeu.appupeunative.databinding.DetallepersonaFragmentBinding
import pe.edu.upeu.appupeunative.databinding.PersonaFragmentBinding
import pe.edu.upeu.appupeunative.modelo.ModeloMsg
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.ui.persona.PersonaViewModel
import pe.edu.upeu.appupeunative.utils.CalendarUtils
import pe.edu.upeu.appupeunative.utils.TokenUtils
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

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

        _binding = DetallepersonaFragmentBinding.inflate(inflater, container, false)
        viewModel =ViewModelProvider(this).get(DetallepersonaViewModel::class.java)

        var idData =arguments?.get("idData").toString()
        Log.i("VERRR", idData)
        if (idData!=="null"){
            viewModel.getPersona(idData).observe(this.requireActivity()){
                    personax->
                if(personax!==null){
                    persona=personax!!
                    binding.txtDni.setText(persona.dni)
                    binding.txtNombre.setText(persona.nombre)
                    binding.txtTelefono.setText(persona.telefono)
                    binding.txtEdad.setText(persona.edad.toString())
                    binding.txtFechaNac.setText(persona.fecha_nac)
                }
                /*mViewBinding.imageView.load(producto.nombre){
                placeholder(R.drawable.ic_photo)
                error(R.drawable.ic_broken_image)
                }*/
            }
        }

        showDatePicker()

        items.add(SearchableItem("Masculino", "M"))
        items.add(SearchableItem("Femenino", "F"))

        binding.txtGenero.setOnClickListener {
            SearchableSingleSelectSpinner.show(requireContext(), "Select Item", items, object :
                SingleSelectionCompleteListener {
                override fun onCompleteSelection(selectedItem: SearchableItem) {
                    Log.e("data", selectedItem.text +" id:"+selectedItem.code)
                    it.txtGenero.setText(selectedItem.text)
                    persona.genero=selectedItem.code
                }
            })
        }

        binding.btnCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_detallepersonaFragment_to_personaFragment)
        }

        binding.btnGuardar.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this.requireContext()).create()
            alertDialog.setTitle("Mensaje de Confirmación")
            alertDialog.setMessage("Esta seguro de registrar una nueva persona?")
            alertDialog.setButton(
                AlertDialog.BUTTON_POSITIVE, "Si"
            ) { dialog, which ->
                persona.dni=binding.txtDni.text.toString()
                persona.nombre=binding.txtNombre.text.toString()
                persona.telefono=binding.txtTelefono.text.toString()
                persona.fecha_nac=binding.txtFechaNac.text.toString()
                persona.edad=binding.txtEdad.text.toString().toInt()
                Log.i("COMPROBAR", idData)
                if (idData!=="null"){
                    viewModel.updatePersona(persona)
                    persona.id=idData
                    viewModel.estado.observe(viewLifecycleOwner, androidx.lifecycle.Observer<ModeloMsg> {
                        if (it.mensaje.toString() == "Se guardo correctamente") {
                            Snackbar.make(binding.root,"Se modifico correctamente",Snackbar.LENGTH_LONG
                            ).setAction("Action", null).show()
                            findNavController().navigate(R.id.action_detallepersonaFragment_to_personaFragment)
                            dialog.dismiss()
                        } else {
                            Snackbar.make(binding.root,"Error al modificar persona",
                                Snackbar.LENGTH_LONG
                            ).setAction("Action", null).show()
                        } }
                    )
                }else {
                    viewModel.createPersona(TokenUtils.TOKEN_CONTENT, persona)
                    viewModel.estado.observe(viewLifecycleOwner, androidx.lifecycle.Observer<ModeloMsg> {

                        if (it.mensaje.toString() == "Se creo correctamente") {
                            Snackbar.make(
                                binding.root,"Se creo correctamente", Snackbar.LENGTH_LONG
                            ).setAction("Action", null).show()
                            findNavController().navigate(R.id.action_detallepersonaFragment_to_personaFragment)
                            dialog.dismiss()
                        } else {
                            Snackbar.make(binding.root,"Error al crear una persona",Snackbar.LENGTH_LONG
                            ).setAction("Action", null).show()
                        }
                    })
                }
            }
            alertDialog.setButton(
                AlertDialog.BUTTON_NEGATIVE, "No"
            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()
        }

        val root: View = binding.root


        return root
    }

    fun showDatePicker() {
        // DatePicker
        binding.txtFechaNac.setText(SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis())) //dd/MM/yyyy
        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val myFormat = "yyyy-MM-dd" // mention the format you need//dd/MM/yyyy
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            binding.txtFechaNac.setText(sdf.format(cal.time))
        }
        binding.txtFechaNac.setOnClickListener {
            Log.d("Clicked", "Interview Date Clicked")
            val dialog = DatePickerDialog(this.requireContext(), dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))
            dialog.datePicker.maxDate = CalendarUtils.getCurrentDateInMillis()
            dialog.show()
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetallepersonaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}