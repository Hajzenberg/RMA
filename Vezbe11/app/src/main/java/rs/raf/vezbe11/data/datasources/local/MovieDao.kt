package rs.raf.vezbe11.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.vezbe11.data.models.MovieEntity

@Dao
abstract class MovieDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: MovieEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insertAll(entities: List<MovieEntity>): Completable

    @Query("SELECT * FROM movies")
    abstract fun getAll(): Observable<List<MovieEntity>>

    @Query("DELETE FROM movies")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<MovieEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

    @Query("SELECT * FROM movies WHERE title LIKE :name || '%'")
    abstract fun getByName(name: String): Observable<List<MovieEntity>>

}