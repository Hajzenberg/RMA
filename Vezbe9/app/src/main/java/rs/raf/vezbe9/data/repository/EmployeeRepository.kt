package rs.raf.vezbe9.data.repository

import io.reactivex.Observable
import rs.raf.vezbe9.data.models.domain.Employee

interface EmployeeRepository {

    fun getEmployees(): Observable<List<Employee>>

}