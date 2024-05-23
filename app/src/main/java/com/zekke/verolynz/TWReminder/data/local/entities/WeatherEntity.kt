package com.zekke.verolynz.TWReminder.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey
    val location: String, // Nama lokasi (misalnya, "Jakarta")
    val temperature: Double,
    val description: String,
    val icon: String, // Kode ikon cuaca dari API (misalnya, "01d")
    val lastUpdated: Long // Timestamp untuk waktu terakhir diperbarui

) {
}