package br.com.raphaelfleury.ageapp.di

import br.com.raphaelfleury.ageapp.network.restclient.AgeApiRestClient
import br.com.raphaelfleury.ageapp.repository.AgeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://aoe4world.com/api/v0/"

    @Singleton
    @Provides
    fun provideAgeRepository(
        ageApiRepository: AgeApiRestClient
    ) = AgeRepository(ageApiRepository)

    @Singleton @Provides
    fun provideAgeApi(client: OkHttpClient): AgeApiRestClient {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(AgeApiRestClient::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}