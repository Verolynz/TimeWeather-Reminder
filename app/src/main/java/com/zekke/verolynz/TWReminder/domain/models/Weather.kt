package com.zekke.verolynz.TWReminder.domain.models


import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class Weather(
    val id: Int = 0,
    val title: String,
    val description: String?,
    val date: Long, // Timestamp untuk tanggal
    val time: Long, // Timestamp untuk waktu
    val weather: Weather? = null, // Informasi cuaca (opsional)
    val icon: String // Kode ikon cuaca
) {
    // Fungsi untuk mendapatkan tanggal dalam format yang mudah dibaca
    fun getFormattedDate(locale: Locale = Locale.getDefault()): String {
        val dateFormat = SimpleDateFormat("EEEE, d MMMM yyyy", locale)
        return dateFormat.format(Date(date))
    }

    // Fungsi untuk mendapatkan waktu dalam format yang mudah dibaca
    fun getFormattedTime(locale: Locale = Locale.getDefault()): String {
        val timeFormat = SimpleDateFormat("HH:mm", locale)
        return timeFormat.format(Date(time))
    }

    // Fungsi untuk memeriksa apakah jadwal sudah lewat dari tanggal dan waktu yang ditentukan
    fun isPastDue(): Boolean {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = date
        calendar.set(Calendar.HOUR_OF_DAY, time.toInt() / 3600000) // Konversi milidetik ke jam
        calendar.set(Calendar.MINUTE, (time % 3600000) / 60000) // Konversi milidetik ke menit
        return calendar.timeInMillis < System.currentTimeMillis()
    }
    // Fungsi untuk mendapatkan URL ikon cuaca dari OpenWeatherMap
    fun getIconUrl(): String {
        return "https://openweathermap.org/img/wn/$icon@2x.png"
    }
}