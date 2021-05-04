package com.sunnyweather.andriod.logic.network

import com.sunnyweather.andriod.SunnyWeatherApplication
import com.sunnyweather.andriod.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2.5/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query")query:String): Call<PlaceResponse>
}