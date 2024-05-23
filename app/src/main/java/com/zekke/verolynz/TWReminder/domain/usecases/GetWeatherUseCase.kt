package com.zekke.verolynz.TWReminder.domain.usecases

import com.zekke.verolynz.TWReminder.domain.models.Weather
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(location: String): Weather? {
        return weatherRepository.getWeatherByLocation(location)
    }
}