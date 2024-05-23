package com.zekke.verolynz.TWReminder.data.local.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository

class WeatherTypeConverter {
    @TypeConverter
    fun fromWeather(weather: WeatherRepository?): String? = Gson().toJson(weather)

    @TypeConverter
    fun toWeather(weatherString: String?): WeatherRepository? = Gson().fromJson(weatherString, WeatherRepository::class.java)
}