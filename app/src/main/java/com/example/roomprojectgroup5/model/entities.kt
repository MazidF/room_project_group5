package com.example.roomprojectgroup5.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "seat_table")
data class Seat(
    @PrimaryKey @ColumnInfo(name = "seat_number") val seatNo: Int,
    @ColumnInfo(name = "student_owner_id") val studentOwnerId : Int,
    @ColumnInfo(name = "seat_position") val position: Int,
)

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "student_id") val id: Int,
    @ColumnInfo(name = "student_name") val name: String,
    @ColumnInfo(name = "student_address") val address: String,
)

@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey @ColumnInfo(name = "course_id") val id :Int,
    @ColumnInfo(name = "instructor_owner_number") val instructorNumber:Int,
    @ColumnInfo(name = "course_name") val name: String,
    @ColumnInfo(name = "course_number") val number: Int,
)

@Entity(tableName = "class_table", foreignKeys = [
    ForeignKey(
        entity = Course::class, parentColumns = arrayOf("course_id"),
        childColumns = arrayOf("course_id")
    )])
data class Clazz(
    @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "section_number") val sectionNumber: Int,
    @ColumnInfo(name = "num_registered") val registered: Int,
    @ColumnInfo(name = "class_data_time") val dataTime: String,
)

@Entity(tableName = "section_table")
data class Section(
    @PrimaryKey @ColumnInfo(name = "section_number") val number: Int,
)

@Entity(tableName = "professor_table")
data class Professor(
    @PrimaryKey @ColumnInfo(name = "professor_id") val id: Int,
    @ColumnInfo(name = "professor_name") val name: String,
    @ColumnInfo(name = "professor_faculty") val faculty: String,
)

@Entity(tableName = "instructor_table")
data class Instructor(
    @PrimaryKey @ColumnInfo(name = "instructor_number") val number:Int,
    @ColumnInfo(name = "instructor_name") val name: String,
    @ColumnInfo(name = "instructor_faculty") val faculty: String,
)