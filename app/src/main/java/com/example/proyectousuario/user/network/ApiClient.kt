package com.example.proyectousuario.user.network


import com.example.proyectousuario.user.network.response.HomeResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val API_URL = "https://api.spoonacular.com/recipes/random/"

    private var miInterface:AppService

    init {
        val restAdapter =
            Retrofit
                .Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                    .connectTimeout(50, TimeUnit.SECONDS)
                    .readTimeout(50, TimeUnit.SECONDS)
                    .addInterceptor(
                        HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
                .build()

        miInterface = restAdapter.create(AppService::class.java)
    }
    fun getServiceClient() = miInterface

    interface AppService {

        @GET(".")
        fun getRecipes(@Query("inc") fieldsToInclude: String,
                                @Query("results") resultsQuantity: Int): Call<HomeResponse>
    }
}




