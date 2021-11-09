package pe.edu.upeu.appupeunative.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pe.edu.upeu.appupeunative.modelo.Persona

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPersona(persona:Persona)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodoPersonas(persona:List<Persona>)

    @Update
    suspend fun actualizarPersona(persona: Persona)

    @Delete
    suspend fun elimiarPersona(persona: Persona)

    @Query("SELECT * FROM persona")
    fun reportarPersonas():Flow<List<Persona>>

    @Query("SELECT * FROM persona WHERE id=:id")
    suspend fun buscarPersonaId(id:String):Persona


}