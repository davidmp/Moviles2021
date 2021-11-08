package pe.edu.upeu.appupeunative.data.remote

import pe.edu.upeu.appupeunative.modelo.Persona
import retrofit2.Response
import retrofit2.http.GET

public interface PersonaApi {

    @GET("/api/persona")
    suspend fun listarPersonas():Response<List<Persona>>

}