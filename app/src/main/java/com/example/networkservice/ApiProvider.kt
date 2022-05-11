package com.example.networkservice

import com.example.models.AuthorModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

const val BASE_URL = "https://apiservice.com/app/api/"

interface ApiProvider {

    @POST("author/getFeaturedAuthorDetail")
    @FormUrlEncoded
    fun getAuthorDetail(@Field("ID") id: String):Call<AuthorModel>
}

object ApiService{
    val apiProvider:ApiProvider
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiProvider = retrofit.create(ApiProvider::class.java)
    }
}
