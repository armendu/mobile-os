package com.example.e0601roomproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase: RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null

        private val noOfThreads = 4;
        val databaseExecuter = Executors.newFixedThreadPool(noOfThreads)

        fun getDatabase(context: Context) : StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, StudentDatabase::class.java, "student_database")
                    .addCallback(databaseCallback)
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private val databaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                databaseExecuter.execute {
                    val studentDao = INSTANCE?.getStudentDao()
                    val studentToAdd = Student(1, "test", "testSurname", "")
                    studentDao?.insertStudent(studentToAdd)
                }
            }
        }
    }
}