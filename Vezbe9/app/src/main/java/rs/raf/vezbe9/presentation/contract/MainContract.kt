package rs.raf.vezbe9.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.vezbe9.data.models.domain.Employee

interface MainContract {

    interface ViewModel {
        val employees: LiveData<List<Employee>>
        val employee: LiveData<Employee>
        val employeeAdded: LiveData<Employee>
        val employeeUpdated: LiveData<String>
        val employeeDeleted: LiveData<String>

        fun getEmployees()
        fun getEmployee(id: String)
        fun addEmployee(name: String, salary: String, age: String)
        fun updateEmployee(id: String, name: String?, salary: String?, age: String?)
        fun delete(id: String)
    }

}