package rs.raf.vezbe10.data.local.datasources

import androidx.room.Dao
import androidx.room.Insert
import io.reactivex.Completable
import rs.raf.vezbe10.data.local.models.CourseEntity

@Dao
abstract class CourseDao {

    @Insert
    abstract fun insert(courseEntity: CourseEntity): Completable

}