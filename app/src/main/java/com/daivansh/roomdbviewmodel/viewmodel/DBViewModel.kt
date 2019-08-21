package com.daivansh.roomdbviewmodel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.daivansh.roomdbviewmodel.db.StudentRoomDatabase
import com.daivansh.roomdbviewmodel.db.dao.StudentDao
import com.daivansh.roomdbviewmodel.db.entity.Student
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DBViewModel(app: Application): AndroidViewModel(app) {

    private val dao: StudentDao = StudentRoomDatabase.getDatabase(app).studentDao()

    private lateinit var studentList: LiveData<List<Student>>
    private lateinit var student: LiveData<Student>

    fun getStudentList(): LiveData<List<Student>> {
        if(!::studentList.isInitialized){
            runBlocking{
                studentList = dao.getStudentList()
            }
        }
        return studentList
    }

    fun getStudentFromID(studentID: String): LiveData<Student> {
        runBlocking{
            student = dao.getStudentFromID(studentID)
        }
        return student
    }

    fun insertStudent(st: Student){
        viewModelScope.launch {
            dao.insert(st)
        }
    }





}