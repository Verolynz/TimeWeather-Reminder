package com.zekke.verolynz.TWReminder.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Update
import com.zekke.verolynz.TWReminder.data.local.entities.ScheduleEntity
import com.zekke.verolynz.TWReminder.data.local.entities.WeatherEntity

@Dao
interface ScheduleDao {
    @Transaction
    @Query("SELECT * FROM schedules")
    fun getAllSchedulesWithWeather(): LiveData<List<ScheduleWithWeather>>

    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :scheduleId")
    suspend fun getScheduleWithWeatherById(scheduleId: Int): ScheduleWithWeather?

    @Query("SELECT * FROM schedules")
    fun getAllSchedules(): LiveData<List<ScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(schedule: ScheduleEntity)

    @Update
    suspend fun updateSchedule(schedule: ScheduleEntity)

    @Delete
    suspend fun deleteSchedule(schedule: ScheduleEntity)

}
data class ScheduleWithWeather(
    @Embedded val schedule: ScheduleEntity,
    @Relation(
        parentColumn = "weatherLocation",
        entityColumn = "location"
    )
    val weather: WeatherEntity?
)