package rs.raf.vezbe9.presentation.viewmodel

import androidx.lifecycle.ViewModel
import rs.raf.vezbe9.data.repository.EmployeeRepository
import rs.raf.vezbe9.presentation.contract.MainContract

class MainViewModel(
    private val employeeRepository: EmployeeRepository
) : ViewModel(), MainContract.ViewModel