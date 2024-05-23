package com.zekke.verolynz.TWReminder.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zekke.verolynz.TWReminder.domain.models.Weather
import com.zekke.verolynz.TWReminder.domain.usecases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weather = MutableLiveData<Weather?>()
    val weather: LiveData<Weather?> = _weather

    fun getWeather(location: String) {
        viewModelScope.launch {
            _weather.value = getWeatherUseCase(location)
        }
    }
}