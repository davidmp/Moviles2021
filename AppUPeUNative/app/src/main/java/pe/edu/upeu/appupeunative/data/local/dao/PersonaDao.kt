package pe.edu.upeu.appupeunative.data.local.dao

import androidx.room.*
import pe.edu.upeu.appupeunative.modelo.Persona

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPersona(vararg persona:Persona)

    @Update
    suspend fun actualizarPersona(vararg persona: Persona)

    @Delete
    suspend fun elimiarPersona(vararg persona: Persona)

    @Query("SELECT * FROM persona")
    suspend fun reportarPersonas():List<Persona>

    @Query("SELECT * FROM persona WHERE id=:id")
    suspend fun buscarPersonaId(id:String):Persona

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPersonas(vararg persona:List<Persona>)

}