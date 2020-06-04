package com.example.edifikarmobileapp.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private var apiService: ApiService? = null

    fun getApiService(): ApiService? {

        if (apiService == null) {
            //val accessToken = Constants.TOKEN
            val okHttpClientBuilder = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)

            okHttpClientBuilder.addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val request = chain.request()
                    val newRequest = request.newBuilder()
                    return chain.proceed(newRequest.build())
                }
            })

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://143.208.132.83/SiteQA/Condominio/ws/api/")
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create(buildGson()))
                    .build()

            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService
    }


    private fun buildGson(): Gson {
        return GsonBuilder()
                .serializeNulls()
                .create()
    }
}