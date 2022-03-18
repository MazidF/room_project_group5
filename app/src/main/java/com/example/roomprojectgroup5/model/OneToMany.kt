package com.example.roomprojectgroup5.model

import androidx.room.Embedded
import androidx.room.Relation

data class InstructorWithCourses(
    @Embedded val instructor: Instructor,
    @Relation(parentColumn = "instructor_number", entityColumn = "instructor_owner_number")
    val courses: List<Course>
)

data class CourseWithClasses(
    @Embedded val course: Course,
    @Relation(parentColumn = "course_id", entityColumn = "course_id")
    val classes : List<Clazz>
)