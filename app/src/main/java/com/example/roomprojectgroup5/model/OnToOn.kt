package com.example.roomprojectgroup5.model

import androidx.room.Embedded
import androidx.room.Relation

data class StudentAndSeat(
    @Embedded val student: Student,
    @Relation(parentColumn = "student_id"
        , entityColumn = "student_owner_id")
    val seat: Seat
)