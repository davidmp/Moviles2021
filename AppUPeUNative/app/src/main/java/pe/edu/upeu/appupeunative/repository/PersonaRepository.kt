package pe.edu.upeu.appupeunative.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import pe.edu.upeu.appupeunative.data.local.dao.PersonaDao
import pe.edu.upeu.appupeunative.data.remote.PersonaApi
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.modelo.State
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class PersonaRepository @Inject constructor(
    private val personaDao: PersonaDao,
    private val personaApi: PersonaApi
) {
    fun getAllPersonas():Flow<State<List<Persona>>>{
        return object: NetworkBoundRepository<List<Persona>, List<Persona>>(){
            override suspend fun saveRemoteDataToLocal(response: List<Persona>) =personaDao.insertarTodoPersonas(response)
            override fun fetchFromLocal(): Flow<List<Persona>> = personaDao.reportarPersonas()
            override suspend fun fetchFromRemote(): Response<List<Persona>> = personaApi.listarPersonas()
        }.asFlow();
    }



}