package rs.raf.vezbe10.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.vezbe10.data.local.datasources.StudentDao

@Database(
    entities = [],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class StudentDatabase : RoomDatabase() {
    // Getteri za sve DAO-e moraju biti navedeni ovde
    abstract fun getStudentDao(): StudentDao
}