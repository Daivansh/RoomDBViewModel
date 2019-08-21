package com.daivansh.roomdbviewmodel.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daivansh.roomdbviewmodel.db.dao.StudentDao
import com.daivansh.roomdbviewmodel.db.entity.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentRoomDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentRoomDatabase? = null

        fun getDatabase(context: Context): StudentRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentRoomDatabase::class.java,
                        "student_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
