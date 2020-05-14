package rs.raf.vezbe10.data.local.repository

import io.reactivex.Completable
import rs.raf.vezbe10.data.local.models.CourseEntity

interface CourseRepository {

    fun insert(courseEntity: CourseEntity): Completable

}