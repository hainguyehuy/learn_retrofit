package com.example.learnretrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        var url : String = "https://jsonplaceholder.typicode.com/"

        fun getRetrofitInstance() : Retrofit{
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()

            return retrofit
        }
    }
}