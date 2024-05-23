package com.zekke.verolynz.TWReminder.data.local.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zekke.verolynz.TWReminder.data.local.dao.ScheduleDao
import com.zekke.verolynz.TWReminder.data.local.dao.WeatherDao
import com.zekke.verolynz.TWReminder.data.local.entities.ScheduleEntity
import com.zekke.verolynz.TWReminder.data.local.typeconverters.WeatherTypeConverter

@Database(entities = [ScheduleEntity::class], version = 1, exportSchema = false)
@TypeConverters(WeatherTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
    abstract fun weatherDao(): WeatherDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "schedule_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}