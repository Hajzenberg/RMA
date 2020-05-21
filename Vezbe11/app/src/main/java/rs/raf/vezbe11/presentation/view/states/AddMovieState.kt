package rs.raf.vezbe11.presentation.view.states

sealed class AddMovieState {
    object Loading: AddMovieState()
    object Success: AddMovieState()
    data class Error(val message: String): AddMovieState()
}