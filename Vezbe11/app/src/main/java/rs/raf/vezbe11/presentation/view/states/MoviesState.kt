package rs.raf.vezbe11.presentation.view.states

import rs.raf.vezbe11.data.models.Movie

sealed class MoviesState {
    object Loading: MoviesState()
    object DataFetched: MoviesState()
    data class Success(val movies: List<Movie>): MoviesState()
    data class Error(val message: String): MoviesState()
}