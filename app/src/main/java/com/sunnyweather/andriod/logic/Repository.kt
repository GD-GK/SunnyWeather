package com.sunnyweather.andriod.logic

import androidx.lifecycle.liveData
import com.sunnyweather.andriod.logic.model.Place
import com.sunnyweather.andriod.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query:String)=liveData(Dispatchers.IO){
        val result =try {
            val placeResponse=SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}