package pe.edu.upeu.appupeunative.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
data class Persona(
    @PrimaryKey var id:String="",
    var dni:String?="",
    var nombre:String?="",
    var telefono:String?="",
    var edad:Int?=0,
    @ColumnInfo(name = "fecha_nac") var fechaNac:String?="",
    var genero:String?=""
)
