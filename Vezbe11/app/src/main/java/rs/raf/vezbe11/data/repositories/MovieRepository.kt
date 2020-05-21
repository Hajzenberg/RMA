package rs.raf.vezbe11.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.vezbe11.data.models.Movie

interface MovieRepository {

    fun fetchAll(): Observable<Unit>
    fun getAll(): Observable<List<Movie>>
    fun getAllByName(name: String): Observable<List<Movie>>
    fun insert(movie: Movie): Completable

}