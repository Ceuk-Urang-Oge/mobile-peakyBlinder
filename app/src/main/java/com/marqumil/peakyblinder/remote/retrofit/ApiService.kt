package com.marqumil.peakyblinder.remote.retrofit

import com.marqumil.peakyblinder.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("https://newsapi.org/v2/everything?q=mental health&apiKey=7759fad0007544b1ae1daed0b0a3b1f2")
    suspend fun getNews(@Query("apiKey") apiKey: String): NewsResponse
}