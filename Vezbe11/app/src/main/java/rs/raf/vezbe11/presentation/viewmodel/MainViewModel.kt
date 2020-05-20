package rs.raf.vezbe11.presentation.viewmodel

import androidx.lifecycle.ViewModel
import rs.raf.vezbe11.data.repositories.MovieRepository
import rs.raf.vezbe11.presentation.contract.MainContract

class MainViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), MainContract.ViewModel