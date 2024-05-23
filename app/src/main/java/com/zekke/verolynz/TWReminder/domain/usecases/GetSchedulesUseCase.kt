package com.zekke.verolynz.TWReminder.domain.usecases

import androidx.lifecycle.LiveData
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleWithWeather
import com.zekke.verolynz.TWReminder.domain.repository.ScheduleRepository
import javax.inject.Inject

class GetSchedulesUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {
    operator fun invoke(): LiveData<List<ScheduleWithWeather>> {
        return scheduleRepository.getAllSchedulesWithWeather()
    }
}