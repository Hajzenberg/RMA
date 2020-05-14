package rs.raf.vezbe10.data.local.repository

import io.reactivex.Completable
import rs.raf.vezbe10.data.local.datasources.CourseDao
import rs.raf.vezbe10.data.local.models.CourseEntity

class CourseRepositoryImpl(private val courseDao: CourseDao): CourseRepository {

    override fun insert(courseEntity: CourseEntity): Completable {
        return courseDao.insert(courseEntity)
    }

}