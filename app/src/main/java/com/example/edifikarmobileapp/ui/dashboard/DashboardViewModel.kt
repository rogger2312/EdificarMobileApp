package com.example.edifikarmobileapp.ui.dashboard

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.edifikarmobileapp.model.ListaProyecto
import com.example.edifikarmobileapp.model.Proyect
import com.example.edifikarmobileapp.service.Helper
import com.example.edifikarmobileapp.service.RetrofitClient
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DashboardViewModel : ViewModel() {

    val responseLiveData = MutableLiveData<List<ListaProyecto>>()
    val dataModel = DataModel()

    init {
        setupObservers()
    }

    private fun setupObservers() {

        dataModel.responseLiveData.observeForever {
            it?.let {
                responseLiveData.value = it
            }
        }

    }
    fun getObservacionesAsignadas() {
        ValidateAndGetTask(this).execute()
    }
}
private class ValidateAndGetTask internal constructor(private var viewModel: DashboardViewModel) : AsyncTask<Void, Void, Boolean>() {

    override fun doInBackground(vararg voids: Void): Boolean? {
        return Helper.isOnline()
    }

    override fun onPostExecute(aBoolean: Boolean?) {
        super.onPostExecute(aBoolean)
        if (aBoolean == true) {
            viewModel.dataModel.load()
        } else {
        }
    }
}
class DataModel {
    private val apiService = RetrofitClient.getApiService()
    val responseLiveData = MutableLiveData<List<ListaProyecto>>()

    fun load() {
        val call = apiService?.proyect(buildJsonBody(2))
        call?.enqueue(object : Callback<Proyect> {
            override fun onFailure(call: Call<Proyect>, t: Throwable) {
                t.printStackTrace()
            }


            override fun onResponse(call: Call<Proyect>, response: Response<Proyect>) {
                if (response.isSuccessful){
                    responseLiveData.value = response.body()!!.results
                }
            }

        });
    }




    private fun buildJsonBody(user: Int): JsonObject {
        val innerJson = JsonObject()
        innerJson.addProperty("idPersona", user)

        return innerJson
    }

}