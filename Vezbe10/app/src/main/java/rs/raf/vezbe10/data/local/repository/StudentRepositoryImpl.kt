package rs.raf.vezbe10.data.local.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.vezbe10.data.local.datasources.StudentDao
import rs.raf.vezbe10.data.local.models.StudentEntity
import rs.raf.vezbe10.data.local.models.StudentNameAndCity
import rs.raf.vezbe10.data.local.models.StudentWithCourses

class StudentRepositoryImpl(private val studentDao: StudentDao): StudentRepository {

    override fun insert(studentEntity: StudentEntity): Completable {
        return studentDao.insertStudent(studentEntity)
    }

    override fun insertAll(studentEntities: List<StudentEntity>): Single<List<Long>> {
        return studentDao.insertStudents(studentEntities)
    }

    override fun getAll(): Observable<List<StudentEntity>> {
        return studentDao.getAll()
    }

    override fun updateNameById(id: Long, name: String): Completable {
        return Completable.fromCallable {
            val student = studentDao.getById(id)
            val updatedStudent = student.copy(
                name = name
            )
            studentDao.update(updatedStudent)
        }
    }

    override fun updateNameById2(id: Long, name: String): Completable {
        return studentDao.updateNameById(id, name)
    }

    override fun deleteAll(): Completable {
        return studentDao.deleteAll()
    }

    override fun getAllWithNameAndCityOnly(): Observable<List<StudentNameAndCity>> {
        return studentDao.getAllWithNameAndCityOnly()
    }

    override fun getAllWithClasses(): Observable<List<StudentWithCourses>> {
        return studentDao.getAllWIthCourses()
    }

    //@Embeded
    //vadjenje skracenog modela
    // relation dodaj tabelu predmet
    // pa preko relation izvadi

}