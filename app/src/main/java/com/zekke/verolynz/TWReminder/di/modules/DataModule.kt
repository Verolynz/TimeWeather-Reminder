package com.zekke.verolynz.TWReminder.di.modules

import android.content.Context
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleDao
import com.zekke.verolynz.TWReminder.data.local.dao.WeatherDao
import com.zekke.verolynz.TWReminder.data.local.database.AppDatabase
import com.zekke.verolynz.TWReminder.data.remote.WeatherApiService
import com.zekke.verolynz.TWReminder.data.repository.ScheduleRepositoryImpl
import com.zekke.verolynz.TWReminder.data.repository.WeatherRepositoryImpl
import com.zekke.verolynz.TWReminder.domain.repository.ScheduleRepository
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideScheduleDao(appDatabase: AppDatabase): ScheduleDao {
        return appDatabase.scheduleDao()
    }

    @Provides
    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao {
        return appDatabase.weatherDao()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(): WeatherApiService {
        return WeatherApiService.create()
    }

    @Provides
    @Singleton
    fun provideScheduleRepository(scheduleDao: ScheduleDao): ScheduleRepository {
        return ScheduleRepositoryImpl(scheduleDao)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherDao: WeatherDao, weatherApiService: WeatherApiService): WeatherRepository {
        return WeatherRepositoryImpl(weatherDao, weatherApiService)
    }
}