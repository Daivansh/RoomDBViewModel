package com.daivansh.roomdbviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daivansh.roomdbviewmodel.db.entity.Student
import com.daivansh.roomdbviewmodel.viewmodel.DBViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dbViewModel: DBViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbViewModel = ViewModelProviders.of(this@MainActivity).get(DBViewModel::class.java)
        dbViewModel.getStudentList().observe(this, Observer {  studentList ->
            studentList?.let {
                tvText.text = "Students count = ${studentList.size}"
//                Toast.makeText(this@MainActivity,"Students count = ${studentList.size}",Toast.LENGTH_LONG)
//                    .show()
            }
        })

        dbViewModel.getStudentFromID("s102").observe(this, Observer {  student ->
            student?.let {
                Toast.makeText(this@MainActivity,"Student name= ${student.studentName}", Toast.LENGTH_LONG).show()
            }
        })

        dbViewModel.insertStudent(Student("s101","Daivansh"))
        dbViewModel.insertStudent(Student("s102","Shubham"))
    }
}
