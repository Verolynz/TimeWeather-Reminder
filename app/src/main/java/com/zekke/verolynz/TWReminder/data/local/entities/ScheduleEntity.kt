package com.zekke.verolynz.TWReminder.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.zekke.verolynz.TWReminder.domain.repository.WeatherRepository

@Entity(
    tableName = "schedules",
    foreignKeys = [
        ForeignKey(
            entity = WeatherEntity::class,
            parentColumns = ["location"],
            childColumns = ["weatherLocation"],
            onDelete = ForeignKey.SET_NULL
        )
    ])
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    val date: Long, // Timestamp untuk tanggal
    val time: Long, // Timestamp untuk waktu
    @ColumnInfo(name = "weatherLocation")
    val weatherLocation: String? = null // Foreign key ke WeatherEntity
) {

}