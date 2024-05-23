package com.zekke.verolynz.TWReminder.data.repository

import androidx.lifecycle.LiveData
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleDao
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleWithWeather
import com.zekke.verolynz.TWReminder.domain.models.Schedule
import com.zekke.verolynz.TWReminder.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleDao: ScheduleDao
) : ScheduleRepository {
    override fun getAllSchedulesWithWeather(): LiveData<List<ScheduleWithWeather>> =
        scheduleDao.getAllSchedulesWithWeather()

    override suspend fun getScheduleWithWeatherById(scheduleId: Int): ScheduleWithWeather? =
        scheduleDao.getScheduleWithWeatherById(scheduleId)

    override suspend fun insertSchedule(schedule: Schedule) {
        scheduleDao.insertSchedule(schedule.toEntity())
    }

    override suspend fun updateSchedule(schedule: Schedule) {
        scheduleDao.updateSchedule(schedule.toEntity())
    }

    override suspend fun deleteSchedule(schedule: Schedule) {
        scheduleDao.deleteSchedule(schedule.toEntity())
    }


}