package com.daivansh.roomdbviewmodel.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_table")
data class Student(@PrimaryKey @ColumnInfo(name = "student_id") val studentID: String
                   , @ColumnInfo(name = "student_name") val studentName: String)
