package com.example.roomprojectgroup5.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomprojectgroup5.R
import com.example.roomprojectgroup5.data.db.*
import com.example.roomprojectgroup5.model.Course
import com.example.roomprojectgroup5.model.Seat
import com.example.roomprojectgroup5.model.Student
import com.example.roomprojectgroup5.model.StudentCourseCrossRef
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val database = MyDatabase.getDatabase(this)


        val studentDao: StudentDao = database.studentDao
        val courseDao: CourseDao = database.courseDao()
        val instructorDao: InstructorDao = database.instructorDao()
        val professorDao: ProfessorDao = database.professorDao()
        val classDao: ClazzDao = database.classDao()
        val selectionDao: SectionDao = database.selectionDao()
        val seatDao = database.seatDao()
        val studentCourseCrossRef = database.studentCourseCrossRefDao()

        val executorService = Executors.newSingleThreadExecutor()

//        val listStudent = List(10) {
//            Student(name ="student$it", address = "address$it")
//        }
//
//        val listSeat = List(10) {
//            Seat(studentOwnerId = it + 1, position = 100 + it)
//        }
//
//        executorService.submit {
//            studentDao.insertStudents(*listStudent.toTypedArray())
//
//            seatDao.insertItems(*listSeat.toTypedArray())
//
//            val list = studentDao.getStudentAndSeat()
//            Log.d("studentandseat",
//                list.joinToString("\n"))
//            println()
//        }
//
//        val listCourse = List(10) {
//            Course(1 + it, (it + 1000), "course$it", it * 10)
//        }
//        executorService.submit {
//            courseDao.insertCourses(*listCourse.toTypedArray())
//        }
//        val studentAndCouse = arrayOf(
//            StudentCourseCrossRef(1, 1),
//            StudentCourseCrossRef(1, 5),
//            StudentCourseCrossRef(3, 1),
//            StudentCourseCrossRef(3, 6),
//            StudentCourseCrossRef(4, 6),
//            StudentCourseCrossRef(2, 9),
//            StudentCourseCrossRef(5, 5),
//            StudentCourseCrossRef(5, 4),
//            StudentCourseCrossRef(6, 5),
//            StudentCourseCrossRef(6, 1),
//            StudentCourseCrossRef(6, 2),
//            StudentCourseCrossRef(6, 3),
//        )
//        executorService.submit {
//            studentCourseCrossRef.insertItems(*studentAndCouse)
//        }

        executorService.submit {
            val list = studentDao.getStudentWithCourse()
            Log.d("studentandseat", list.joinToString("\n"))
            println()
        }
    }
}