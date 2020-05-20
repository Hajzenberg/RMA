package rs.raf.vezbe11.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.vezbe11.data.datasources.local.MovieDataBase
import rs.raf.vezbe11.data.datasources.remote.MovieService
import rs.raf.vezbe11.data.repositories.MovieRepository
import rs.raf.vezbe11.data.repositories.MovieRepositoryImpl
import rs.raf.vezbe11.presentation.viewmodel.MainViewModel

val movieModule = module {

    viewModel { MainViewModel(movieRepository = get()) }

    single<MovieRepository> { MovieRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }

    single { get<MovieDataBase>().getMovieDao() }

    single<MovieService> { create(retrofit = get()) }

}

