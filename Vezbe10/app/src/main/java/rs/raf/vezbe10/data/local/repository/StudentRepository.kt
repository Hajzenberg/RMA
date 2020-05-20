package rs.raf.vezbe10.data.local.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.vezbe10.data.local.models.StudentEntity
import rs.raf.vezbe10.data.local.models.StudentNameAndCity
import rs.raf.vezbe10.data.local.models.StudentWithCourses

interface StudentRepository {

    fun insert(studentEntity: StudentEntity): Completable

    fun insertAll(studentEntities: List<StudentEntity>): Single<List<Long>>

    fun getAll(): Observable<List<StudentEntity>>

    fun updateNameById(id: Long, name: String): Completable

    fun updateNameById2(id: Long, name: String): Completable

    fun deleteAll(): Completable

    fun getAllWithNameAndCityOnly(): Observable<List<StudentNameAndCity>>

    fun getAllWithClasses(): Observable<List<StudentWithCourses>>

}