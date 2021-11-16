package pe.edu.upeu.appupeunative.ui.persona

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.modelo.State
import pe.edu.upeu.appupeunative.modelo.User
import pe.edu.upeu.appupeunative.repository.PersonaRepository
import pe.edu.upeu.appupeunative.utils.TokenUtils

@ExperimentalCoroutinesApi
class PersonaViewModel @ViewModelInject constructor(
    private val personaRepository: PersonaRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    // TODO: Implement the ViewModel
    private val _personasLiveData= MutableLiveData<State<List<Persona>>>()
    val personasLidaData: LiveData<State<List<Persona>>>
        get() =_personasLiveData
    fun getPersonas(){
        viewModelScope.launch { personaRepository.getAllPersonas().collect{
            _personasLiveData.value=it
        } }
    }

    fun deleteProductById(persona: Persona){
        viewModelScope.launch {
            personaRepository.deletePersonaById(persona)
            personaRepository.getAllPersonas().collect{
                _personasLiveData.value=it
            }
        }
    }

    fun login(user: User){
        viewModelScope.launch {
            personaRepository.loginUser(user).also {
                TokenUtils.TOKEN_CONTENT="JWT "+it!!.access_token
                Log.i("TOKEN", TokenUtils.TOKEN_CONTENT)
            }
        }
    }

}