package com.example.roomprojectgroup5.data.db

import androidx.room.*
import com.example.roomprojectgroup5.model.*

@Dao
interface StudentDao {

    @Transaction
    @Query("select * from student_table")
    fun getStudentWithCourse() : List<StudentWithCourses>

    @Transaction
    @Query("select * from student_table")
    fun getStudentAndSeat() : List<StudentAndSeat>

    @Query("select * from student_table")
    fun getStudents() : List<Student>

    @Insert
    fun insertStudents(vararg students: Student) : List<Long>

    @Update
    fun updateStudents(vararg students: Student) : Int

    @Delete
    fun deleteStudents(vararg students: Student) : Int

}

@Dao
interface CourseDao {

    @Transaction
    @Query("select * from course_table")
    fun getCoursesWithClasses() : List<CourseWithClasses>

    @Query("select * from course_table")
    fun getCourses() : List<Course>

    @Insert
    fun insertCourses(vararg students: Course) : List<Long>

    @Update
    fun updateCourses(vararg students: Course) : Int

    @Delete
    fun deleteCourses(vararg students: Course) : Int

}

@Dao
interface ClazzDao {

    @Query("select * from class_table")
    fun getClazzs() : List<Clazz>

    @Insert
    fun insertClazzs(vararg students: Clazz) : List<Long>

    @Update
    fun updateClazzs(vararg students: Clazz) : Int

    @Delete
    fun deleteClazzs(vararg students: Clazz) : Int
}

@Dao
interface InstructorDao {

    @Transaction
    @Query("select * from instructor_table")
    fun getInstructorsWithCourses() : List<InstructorWithCourses>

    @Query("select * from instructor_table")
    fun getInstructors() : List<Instructor>

    @Insert
    fun insertInstructors(vararg students: Instructor) : List<Long>

    @Update
    fun updateInstructors(vararg students: Instructor) : Int

    @Delete
    fun deleteInstructors(vararg students: Instructor) : Int
}

@Dao
interface ProfessorDao : MyDao<Professor, Int> {

    @Query("select * from professor_table")
    override fun getItems(): List<Professor>
}

@Dao
interface SectionDao : MyDao<Section, Int> {

    @Query("select * from section_table")
    override fun getItems(): List<Section>
}

@Dao
interface MyDao<Item, PrimaryKey> {

    fun getItems() : List<Item>

    @Insert
    fun insertItems(vararg items: Item) : List<Long>

    @Update
    fun updateItems(vararg items: Item) : Int

    @Delete
    fun deleteItems(vararg items: Item) : Int
}

@Dao
interface SeatDao : MyDao<Seat, Int> {

    @Query("select * from seat_table")
    override fun getItems(): List<Seat>
}

@Dao
interface StudentCourseCrossRefDao {

    @Insert
    fun insertItems(vararg studentCourseCrossRef: StudentCourseCrossRef) : List<Long>
}
