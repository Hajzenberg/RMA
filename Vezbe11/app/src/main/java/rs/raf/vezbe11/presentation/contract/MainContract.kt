package rs.raf.vezbe11.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.vezbe11.data.models.Movie
import rs.raf.vezbe11.presentation.view.states.AddMovieState
import rs.raf.vezbe11.presentation.view.states.MoviesState

interface MainContract {

    interface ViewModel {

        val moviesState: LiveData<MoviesState>
        val addDone: LiveData<AddMovieState>

        fun fetchAllMovies()
        fun getAllMovies()
        fun getMoviesByName(name: String)
        fun addMovie(movie: Movie)
    }

}