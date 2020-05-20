package rs.raf.vezbe11.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.vezbe11.data.models.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class MovieDataBase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}