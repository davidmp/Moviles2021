package pe.edu.upeu.appupeunative.ui.persona.detallepersona

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import pe.edu.upeu.appupeunative.modelo.ModeloMsg
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.repository.PersonaRepository

@ExperimentalCoroutinesApi
class DetallepersonaViewModel @ViewModelInject constructor(
    private val personaRepository: PersonaRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    // TODO: Implement the ViewModel
    fun getPersona(id:String)=personaRepository.getPersonaById(id).asLiveData()
    val estado = MutableLiveData<ModeloMsg>()
    fun createPersona(token:String,persona: Persona){
        viewModelScope.launch {
            Log.i("LLEGA_TOKEN", token)
            personaRepository.insertProduct(token,persona).apply {
                estado.value = this
                estado.value?.let { Log.i("CREADO", it.mensaje.toString()) }
            }
            /*personaRepository.getAllProductos().collect{
            //_productosLiveData.value=it
            }*/
        }
    }


    fun updatePersona(persona: Persona){
        Log.i("LLEGA_UX", "Si actualizara!"+persona.id)
        viewModelScope.launch {
            personaRepository.updatePersona(persona).apply {
                estado.value = ModeloMsg(mensaje = "Se guardo correctamente")
            }
            getPersona(persona.id!!)
        }
    }


}