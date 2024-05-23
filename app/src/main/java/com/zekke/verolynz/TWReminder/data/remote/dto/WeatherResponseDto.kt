package com.zekke.verolynz.TWReminder.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.zekke.verolynz.TWReminder.domain.models.Weather

data class WeatherResponseDto(
    val coord: Coord,
    val weather: List<WeatherDescription>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    @SerializedName("name") val locationName: String,
    val cod: Int
) {
    // Fungsi untuk mengonversi WeatherResponseDto menjadi Weather (domain model)
    fun toDomainModel(): Weather {
        return Weather(
            location = locationName,
            temperature = main.temp,
            description = weather[0].description,
            icon = weather[0].icon
        )
    }
}

data class Coord(
    val lon: Double,
    val lat: Double
)

data class WeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class Clouds(
    val all: Int
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)