package com.rigel.NewzTEST

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query
const  val Base_url="https://newsapi.org/v2/"
const val apikey="962a1c54b51d4cbc91d11a641c1646c0"

interface apiinterface {
    @GET("top-headlines?apiKey=$apikey")
    fun getMynews(@Query("country")mycount:String,@Query("category")myworld:String,@Query("pageSize")noofpage:Int):Call<newsz>
    @GET("top-headlines?apiKey=$apikey")
    fun getMynews(@Query("country")mycount:String,@Query("pageSize")noofpage:Int):Call<newsz>

}