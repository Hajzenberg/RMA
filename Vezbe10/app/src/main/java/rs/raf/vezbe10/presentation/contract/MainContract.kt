package rs.raf.vezbe10.presentation.contract

import rs.raf.vezbe10.data.local.models.CourseEntity
import rs.raf.vezbe10.data.local.models.StudentEntity

interface MainContract {

    interface ViewModel {

        fun insertStudent(studentEntity: StudentEntity)
        fun insertStudents(studentEntities: List<StudentEntity>)
        fun getAllStudents()
        fun updateStudentNameById(id: Long, name: String)
        fun updateStudentNameById2(id: Long, name: String)
        fun deleteAllStudents()
        fun getAllStudentsWithNameAndCity()
        fun insertCourse(courseEntity: CourseEntity)
        fun getAllStudentsWithClasses()
    }

}