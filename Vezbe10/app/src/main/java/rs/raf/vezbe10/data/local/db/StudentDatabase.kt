package rs.raf.vezbe10.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.vezbe10.data.local.datasources.CourseDao
import rs.raf.vezbe10.data.local.datasources.StudentDao
import rs.raf.vezbe10.data.local.db.converters.DateConverter
import rs.raf.vezbe10.data.local.db.converters.StringListConverter
import rs.raf.vezbe10.data.local.models.CourseEntity
import rs.raf.vezbe10.data.local.models.StudentEntity

@Database(
    entities = [StudentEntity::class, CourseEntity::class],
    version = 3,
    exportSchema = false)
@TypeConverters(StringListConverter::class, DateConverter::class)
abstract class StudentDatabase : RoomDatabase() {
    // Getteri za sve DAO-e moraju biti navedeni ovde
    abstract fun getStudentDao(): StudentDao
    abstract fun getCourseDao(): CourseDao
}