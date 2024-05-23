package com.zekke.verolynz.TWReminder.domain.repository

import com.zekke.verolynz.TWReminder.domain.models.Weather

interface WeatherRepository {
    suspend fun getWeatherByLocation(location: String): Weather?
}