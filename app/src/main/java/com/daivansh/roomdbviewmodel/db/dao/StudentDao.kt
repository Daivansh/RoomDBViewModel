package com.daivansh.roomdbviewmodel.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daivansh.roomdbviewmodel.db.entity.Student


@Dao
interface StudentDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from student_table ORDER BY student_id ASC")
    fun getStudentList(): LiveData<List<Student>>

    @Query("SELECT * from student_table Where student_id = :studentID")
    fun getStudentFromID(studentID: String): LiveData<Student>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAll()
}
