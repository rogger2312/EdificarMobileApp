package com.example.edifikarmobileapp.service

import com.example.edifikarmobileapp.model.Proyect
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("Proyecto/ListarProyectoPorEmpresa")
    fun proyect(@Body jsonObject: JsonObject): Call<Proyect>
}