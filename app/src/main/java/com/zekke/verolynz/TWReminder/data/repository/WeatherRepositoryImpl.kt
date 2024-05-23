package com.zekke.verolynz.TWReminder.data.repository

import com.zekke.verolynz.TWReminder.data.local.dao.WeatherDao
import com.zekke.verolynz.TWReminder.data.remote.WeatherApiService
import com.zekke.verolynz.TWReminder.domain.models.Weather
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val weatherApiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getWeatherByLocation(location: String): Weather? {
        // Coba ambil dari database lokal dulu
        val cachedWeather = weatherDao.getWeatherByLocation(location)
        if (cachedWeather != null && !isWeatherDataExpired(cachedWeather.lastUpdated)) {
            return cachedWeather.toDomainModel()
        }

        // Jika tidak ada di cache atau sudah kadaluarsa, ambil dari API
        return try {
            val response = weatherApiService.getWeatherByLocation(location)
            val weather = response.body()?.toDomainModel()
            if (weather != null) {
                weatherDao.insertWeather(weather.toEntity())
            }
            weather
        } catch (e: Exception) {
            // Tangani kesalahan jaringan atau API
            null
        }
    }
    // Fungsi untuk memeriksa apakah data cuaca sudah kadaluarsa (misalnya, 1 jam)
    private fun isWeatherDataExpired(lastUpdated: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime - lastUpdated > 3600000 // 1 jam dalam milidetik
    }

}