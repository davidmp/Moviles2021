package pe.edu.upeu.appupeunative.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pe.edu.upeu.appupeunative.data.remote.PersonaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RemoteApiModulo {
    @Singleton
    @Provides
    fun provideRetrofitService():PersonaApi=Retrofit.Builder().baseUrl(PersonaApi.SERVICIO_APP_API_URL)
        .addConverterFactory(MoshiConverterFactory.create(
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        )).build().create(PersonaApi::class.java)
}