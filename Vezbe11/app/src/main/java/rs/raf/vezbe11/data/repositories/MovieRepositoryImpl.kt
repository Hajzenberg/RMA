package rs.raf.vezbe11.data.repositories

import rs.raf.vezbe11.data.datasources.local.MovieDao
import rs.raf.vezbe11.data.datasources.remote.MovieService

class MovieRepositoryImpl(
    private val localDataSource: MovieDao,
    private val remoteDataSource: MovieService
) : MovieRepository {

}