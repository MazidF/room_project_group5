package com.example.roomprojectgroup5.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithCourses(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "student_id",
        entityColumn = "course_id",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val courses: List<Course>
)

data class CourseWithStudents(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "course_id",
        entityColumn = "student_id",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val students: List<Student>
)
