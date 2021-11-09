package pe.edu.upeu.appupeunative.di
import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pe.edu.upeu.appupeunative.data.local.AppupeuNativeDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class LocalDatabaseModulo {

    @Singleton
    @Provides
    fun provideDatabase(application: Application)=AppupeuNativeDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providePersonaDao(database: AppupeuNativeDatabase)=database.getPersonaDao()

}