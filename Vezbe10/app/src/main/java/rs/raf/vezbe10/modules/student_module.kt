package rs.raf.vezbe10.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.vezbe10.presentation.viewmodels.MainViewModel

val studentModule = module {

    viewModel { MainViewModel() }



}

