package com.zekke.verolynz.TWReminder.domain.usecases

import com.zekke.verolynz.TWReminder.domain.models.Schedule
import com.zekke.verolynz.TWReminder.domain.repository.ScheduleRepository
import javax.inject.Inject

class AddScheduleUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {
    suspend operator fun invoke(schedule: Schedule) {
        scheduleRepository.insertSchedule(schedule)
    }
}