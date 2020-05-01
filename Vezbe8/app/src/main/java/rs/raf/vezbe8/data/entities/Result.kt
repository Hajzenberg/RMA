package rs.raf.vezbe8.data.entities

sealed class Result<out T> {
    class Loading<out T>(): Result<T>()
    data class Success<out T>(val data: T): Result<T>()
    class Error<out T>(val message: String): Result<T>()
}