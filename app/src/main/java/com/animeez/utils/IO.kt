package com.animeez.utils

import okhttp3.Interceptor
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class IO {
    companion object{

        fun fetchFromUrl(address: String, callback: (response: String)-> Unit){
            Thread{
                val url = URL(address)
                val con = url.openConnection()
                BufferedReader(InputStreamReader(con.getInputStream()) ).use {
                    val text = it.readText()
                    callback(text)
                }
            }.start()
        }

        fun createInterceptor() = Interceptor { chain ->
            val originalRequest = chain.request()
            val originalRequestWithAPI = originalRequest.url.newBuilder().addQueryParameter(
                "",""
            ).build()
            val newRequest = originalRequest.newBuilder().url(originalRequestWithAPI).build()
            chain.proceed(newRequest)
        }

    }
}