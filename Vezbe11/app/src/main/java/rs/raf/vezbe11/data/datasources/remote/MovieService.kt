package rs.raf.vezbe11.data.datasources.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rs.raf.vezbe11.data.models.MovieResponse

interface MovieService {

    @GET("films")
    fun getAll(@Query("limit") limit: Int = 1000): Observable<List<MovieResponse>>

}