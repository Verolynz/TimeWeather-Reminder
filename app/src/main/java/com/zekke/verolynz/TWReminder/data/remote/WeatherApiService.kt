package com.zekke.verolynz.TWReminder.data.remote

import com.zekke.verolynz.TWReminder.data.remote.dto.WeatherResponseDto
import retrofit2.http.Query
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApiService {

    @GET("data/2.5/weather")
    suspend fun getWeatherByLocation(
        @Query("q") location: String,
        @Query("appid") apiKey: String = BuildConfig.OPEN_WEATHER_MAP_API_KEY,
        @Query("units") units: String = "metric" // Menggunakan Celsius
    ): Response<WeatherResponseDto>

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/"

        fun create(): WeatherApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WeatherApiService::class.java)
        }
    }
}