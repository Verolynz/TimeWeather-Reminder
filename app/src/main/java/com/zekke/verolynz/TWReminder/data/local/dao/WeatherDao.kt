package com.zekke.verolynz.TWReminder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zekke.verolynz.TWReminder.data.local.entities.WeatherEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather WHERE location = :location")
    suspend fun getWeatherByLocation(location: String): WeatherEntity?
}