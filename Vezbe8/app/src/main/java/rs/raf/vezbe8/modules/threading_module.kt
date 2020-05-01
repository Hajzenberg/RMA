package rs.raf.vezbe8.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.vezbe8.presentation.viewmodels.ThreadViewModel

val threadingModule = module {

    viewModel { ThreadViewModel() }

}