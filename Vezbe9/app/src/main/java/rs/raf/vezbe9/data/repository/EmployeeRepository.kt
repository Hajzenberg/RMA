package rs.raf.vezbe9.data.repository

import io.reactivex.Observable
import rs.raf.vezbe9.data.models.domain.Employee

interface EmployeeRepository {

    fun getEmployees(): Observable<List<Employee>>

    fun getEmployee(id: String): Observable<Employee>

    fun addEmployee(name: String, salary: String, age: String): Observable<Employee>

    fun updateEmployee(id: String, name: String?, salary: String?, age: String?): Observable<String>

    fun delete(id: String): Observable<String>

}