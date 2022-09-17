package com.rigel.NewzTEST

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class apiutility {

    companion object{
        var retrofit:Retrofit?=null
        fun getMyApi(): apiinterface {
            if(retrofit==null){
                retrofit=Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build()

            }
            return retrofit!!.create(apiinterface::class.java)
        }
    }


}