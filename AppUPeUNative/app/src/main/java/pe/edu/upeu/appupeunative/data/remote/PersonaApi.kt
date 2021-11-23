package pe.edu.upeu.appupeunative.data.remote

import pe.edu.upeu.appupeunative.modelo.ModeloMsg
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.modelo.Token
import pe.edu.upeu.appupeunative.modelo.User
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
    suspend fun deletePersona(@Path("id") id:String):Response<ModeloMsg>

    @PATCH("/api/personaut/{id}")
    suspend fun updatePersona(@Path("id") id:String, @Body persona: Persona):Response<ModeloMsg>

    @POST("/api/persona/crear")
    suspend fun createPersona(@Header("Authorization") token:String, @Body persona: Persona):ModeloMsg

    @POST("/api/auth")
    suspend fun login(@Body user: User):Token


}