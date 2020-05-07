package rs.raf.vezbe9.data.models.domain

sealed class Resource<out T> {
    class Loading<out T>(): Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    class Error<out T>(val message: String): Resource<T>()
}