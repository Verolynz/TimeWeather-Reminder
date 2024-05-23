package com.zekke.verolynz.TWReminder.domain.models

data class Schedule(
    val id: Int = 0,
    val title: String,
    val description: String?,
    val date: Long, // Timestamp untuk tanggal
    val time: Long, // Timestamp untuk waktu
    val weather: Weather? = null // Informasi cuaca (opsional)
)