package com.pixelart.week4daily2.remotes

import com.pixelart.week4daily2.APPID
import com.pixelart.week4daily2.BASE_WEATHER_URL
import com.pixelart.week4daily2.ZIP
import com.pixelart.week4daily2.model.WeatherData
import io.reactivex.Single
import retrofit2.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RemoteHelper {

    fun getWeatherData() : Single<WeatherData>{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_WEATHER_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RemoteService::class.java)

        return service.getWeatherData(ZIP, APPID)
    }

    /*fun getWeatherData() : Call<ResponseBody>{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_WEATHER_URL)
            .build()

        val service = retrofit.create(RemoteService::class.java)

        return service.getWeatherData(ZIP, APPID)
    }*/
}