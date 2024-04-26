package com.example.plantapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Plant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        // Multiple threads can potentially ask for a database instance at the same time,
        // which results in two databases instead of one. This issue is known as a race condition.
        // Wrapping the code to get the database inside a synchronized block means that only
        // one thread of execution at a time can enter this block of code, which makes sure
        // the database only gets initialized once.
        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}