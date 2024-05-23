package com.zekke.verolynz.TWReminder.domain.repository

import androidx.lifecycle.LiveData
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleWithWeather
import com.zekke.verolynz.TWReminder.domain.models.Schedule

interface ScheduleRepository {
    fun getAllSchedulesWithWeather(): LiveData<List<ScheduleWithWeather>>
    suspend fun getScheduleWithWeatherById(scheduleId: Int): ScheduleWithWeather?
    suspend fun insertSchedule(schedule: Schedule)
    suspend fun updateSchedule(schedule: Schedule)
    suspend fun deleteSchedule(schedule: Schedule)
}