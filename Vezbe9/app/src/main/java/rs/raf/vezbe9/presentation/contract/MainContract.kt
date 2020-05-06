package rs.raf.vezbe9.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.vezbe9.data.models.domain.Employee

interface MainContract {

    interface ViewModel {
        val employees: LiveData<List<Employee>>

        fun getEmployees()
    }

}