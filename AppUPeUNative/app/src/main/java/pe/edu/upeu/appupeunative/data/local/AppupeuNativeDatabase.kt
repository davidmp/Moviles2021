package pe.edu.upeu.appupeunative.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.data.local.dao.PersonaDao

@Database(
    entities = arrayOf(Persona::class,), version = DatabaseMigrations.DB_VERSION
)
//@TypeConverters(Converters::class)
abstract class AppupeuNativeDatabase : RoomDatabase() {

    abstract fun getPersonaDao(): PersonaDao

    companion object {
        const val DB_NAME = "appupeu_native"

        @Volatile
        private var INSTANCE: AppupeuNativeDatabase? = null

        fun getInstance(context: Context): AppupeuNativeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppupeuNativeDatabase::class.java,
                    DB_NAME
                ).addMigrations(*DatabaseMigrations.MIGRATIONS).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}