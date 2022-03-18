package com.example.roomprojectgroup5.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "seat_table")
data class Seat(
    @ColumnInfo(name = "seat_no") val seatNo: Int,
    @ColumnInfo(name = "seat_position") val position: Int,
)

@Entity(tableName = "student_table")
data class Student(
    @ColumnInfo(name = "student_id") val id: Int,
    @ColumnInfo(name = "student_name") val name: String,
    @ColumnInfo(name = "student_address") val address: String,
)

@Entity(tableName = "course_table")
data class Course(
    @ColumnInfo(name = "course_name") val name: String,
    @ColumnInfo(name = "course_number") val number: Int,
)

@Entity(tableName = "class_table")
data class Clazz(
    @ColumnInfo(name = "course_name") val courseName: String,
    @ColumnInfo(name = "section_number") val sectionNumber: Int,
    @ColumnInfo(name = "num_registered") val registered: Int,
    @ColumnInfo(name = "class_data_time") val dataTime: String,
)

@Entity(tableName = "section_table")
data class Section(
    @ColumnInfo(name = "section_number") val number: Int,
)

@Entity(tableName = "professor_table")
data class Professor(
    @ColumnInfo(name = "professor_id") val id: Int,
    @ColumnInfo(name = "professor_name") val name: String,
    @ColumnInfo(name = "professor_faculty") val faculty: String,
)