package com.example.endproject.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.endproject.FilmAdapter
import com.example.endproject.FilmsList
import com.example.endproject.KinopoiskApiService
import com.example.endproject.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    private val _items = MutableLiveData<FilmsList>()
    val items: LiveData<FilmsList> get() = _items

    fun fetchSearchedFilms(){
        RetrofitClient.instance.getAllFilms().enqueue(object : Callback<FilmsList> {
            override fun onResponse(call: Call<FilmsList>, response: Response<FilmsList>) {
                Log.i("Request", response.toString())
                if (response.isSuccessful) {
                    Log.i("Request", response.body().toString())
                    _items.value = response.body()
                }
            }

            override fun onFailure(call: Call<FilmsList>, t: Throwable) {
                Log.i("Request", "Sosi Bydlo")
            }
        })
    }

    fun fetchFilms() {
        RetrofitClient.instance.getAllFilms().enqueue(object : Callback<FilmsList> {
            override fun onResponse(call: Call<FilmsList>, response: Response<FilmsList>) {
                Log.i("Request", response.toString())
                if (response.isSuccessful) {
                    Log.i("Request", response.body().toString())
                    _items.value = response.body()
                }
            }

            override fun onFailure(call: Call<FilmsList>, t: Throwable) {
                Log.i("Request", "Sosi Bydlo")
            }
        })
    }
}