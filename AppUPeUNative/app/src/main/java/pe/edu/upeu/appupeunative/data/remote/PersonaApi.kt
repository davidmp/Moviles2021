package pe.edu.upeu.appupeunative.data.remote

import pe.edu.upeu.appupeunative.modelo.ModeloMsg
import pe.edu.upeu.appupeunative.modelo.Persona
import retrofit2.Response
import retrofit2.http.*

public interface PersonaApi {

    companion object{
        const val SERVICIO_APP_API_URL="http://192.168.1.143:6060"
    }

    @GET("/api/persona")
    suspend fun listarPersonas():Response<List<Persona>>

    @GET("/api/persona/{id}")
    suspend fun getPersonaId(@Header("Authorization") token:String, @Query("id") id:Int):Response<List<Persona>>

    @DELETE("/api/persona/{id}")
    suspend fun deletePersona(@Path("id") id:Int):Response<ModeloMsg>

    @PATCH("/api/persona/{id}")
    suspend fun updatePersona(@Path("id") id:Int, @Body persona: Persona):Response<ModeloMsg>

    @POST("/api/persona/crear")
    suspend fun createPersona(@Body persona: Persona):Response<ModeloMsg>


}