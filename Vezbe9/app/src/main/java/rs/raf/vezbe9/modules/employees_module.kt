package rs.raf.vezbe9.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.vezbe9.data.datasources.EmployeeDataSource
import rs.raf.vezbe9.data.repository.EmployeeRepository
import rs.raf.vezbe9.data.repository.EmployeeRepositoryImpl
import rs.raf.vezbe9.presentation.viewmodel.MainViewModel

val employeesModule = module {

    viewModel { MainViewModel(get()) }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }

    single<EmployeeDataSource> { create(get()) }

}