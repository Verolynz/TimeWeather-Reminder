package com.zekke.verolynz.TWReminder.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleWithWeather
import com.zekke.verolynz.TWReminder.domain.models.Schedule
import com.zekke.verolynz.TWReminder.domain.usecases.AddScheduleUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.DeleteScheduleUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.GetSchedulesUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.UpdateScheduleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val addScheduleUseCase: AddScheduleUseCase,
    private val getSchedulesUseCase: GetSchedulesUseCase,
    private val updateScheduleUseCase: UpdateScheduleUseCase,
    private val deleteScheduleUseCase: DeleteScheduleUseCase
) : ViewModel() {
    val schedules: LiveData<List<ScheduleWithWeather>> = getSchedulesUseCase()

    fun addSchedule(schedule: Schedule) {
        viewModelScope.launch {
            addScheduleUseCase(schedule)
        }
    }

    fun updateSchedule(schedule: Schedule) {
        viewModelScope.launch {
            updateScheduleUseCase(schedule)
        }
    }

    fun deleteSchedule(schedule: Schedule) {
        viewModelScope.launch {
            deleteScheduleUseCase(schedule)
        }
    }
}