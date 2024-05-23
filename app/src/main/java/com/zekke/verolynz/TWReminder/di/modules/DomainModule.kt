package com.zekke.verolynz.TWReminder.di.modules

import com.zekke.verolynz.TWReminder.domain.repository.ScheduleRepository
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository
import com.zekke.verolynz.TWReminder.domain.usecases.AddScheduleUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.DeleteScheduleUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.GetSchedulesUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.GetWeatherUseCase
import com.zekke.verolynz.TWReminder.domain.usecases.UpdateScheduleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideAddScheduleUseCase(scheduleRepository: ScheduleRepository): AddScheduleUseCase {
        return AddScheduleUseCase(scheduleRepository)
    }

    @Provides
    fun provideGetSchedulesUseCase(scheduleRepository: ScheduleRepository): GetSchedulesUseCase {
        return GetSchedulesUseCase(scheduleRepository)
    }

    @Provides
    fun provideUpdateScheduleUseCase(scheduleRepository: ScheduleRepository): UpdateScheduleUseCase {
        return UpdateScheduleUseCase(scheduleRepository)
    }

    @Provides
    fun provideDeleteScheduleUseCase(scheduleRepository: ScheduleRepository): DeleteScheduleUseCase {
        return DeleteScheduleUseCase(scheduleRepository)
    }

    @Provides
    fun provideGetWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }
}