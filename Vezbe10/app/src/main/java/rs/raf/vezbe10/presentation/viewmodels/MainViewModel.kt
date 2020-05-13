package rs.raf.vezbe10.presentation.viewmodels

import androidx.lifecycle.ViewModel
import rs.raf.vezbe10.data.local.repository.StudentRepository
import rs.raf.vezbe10.presentation.contract.MainContract

class MainViewModel(
    private val studentRepository: StudentRepository
) : ViewModel(), MainContract.ViewModel {



}