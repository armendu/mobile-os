package com.example.classstudentmanagement.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.classstudentmanagement.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class UniversityDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao

    companion object {
        @Volatile
        private var INSTANCE : UniversityDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UniversityDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UniversityDatabase::class.java,
                    "university_database"
                )
                    .addCallback(UniversityDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

    private class UniversityDatabaseCallback(val scope : CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE.let { universityDatabase ->
                scope.launch {
                    universityDatabase!!.studentDao.addStudent(
                        Student(
                            2,
                            "name1",
                            "Surname1",
                            "2000-04-05"
                        )
                    )
                }
            }
        }
    }
}