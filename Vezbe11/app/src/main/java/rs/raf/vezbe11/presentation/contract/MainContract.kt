package rs.raf.vezbe11.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.vezbe11.data.models.Movie

interface MainContract {

    interface ViewModel {

        val movies: LiveData<List<Movie>>
        val addDone: LiveData<Boolean>

        fun fetchAllMovies()
        fun getAllMovies()
        fun getMoviesByName(name: String)
        fun addMovie(movie: Movie)
    }

}