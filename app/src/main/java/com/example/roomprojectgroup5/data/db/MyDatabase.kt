package com.example.roomprojectgroup5.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomprojectgroup5.model.*

@Database(
    entities = [StudentCourseCrossRef::class, Course::class, Student::class,
        Instructor::class, Professor::class, Seat::class, Section::class, Clazz::class],
    version = 1,
    exportSchema = true
)
abstract class MyDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao
    abstract fun courseDao() : CourseDao
    abstract fun instructorDao() : InstructorDao
    abstract fun professorDao() : ProfessorDao
    abstract fun classDao() : ClazzDao
    abstract fun selectionDao() : SectionDao
    abstract fun seatDao() : SeatDao
    abstract fun studentCourseCrossRefDao() : StudentCourseCrossRefDao


    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context) : MyDatabase {
            return INSTANCE ?: synchronized(this) {
                if (INSTANCE != null) {
                    return@synchronized INSTANCE!!
                }
                val database = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = database
                database
            }
        }
    }

}