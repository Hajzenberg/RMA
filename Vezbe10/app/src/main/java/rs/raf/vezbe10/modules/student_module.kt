package rs.raf.vezbe10.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.vezbe10.data.local.db.StudentDatabase
import rs.raf.vezbe10.data.local.repository.StudentRepository
import rs.raf.vezbe10.data.local.repository.StudentRepositoryImpl
import rs.raf.vezbe10.presentation.viewmodels.MainViewModel

val studentModule = module {

    viewModel { MainViewModel(get()) }

    single<StudentRepository> { StudentRepositoryImpl(get()) }

    single { get<StudentDatabase>().getStudentDao() }

}

