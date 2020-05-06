package rs.raf.vezbe9.data.repository

import io.reactivex.Observable
import rs.raf.vezbe9.data.datasources.EmployeeDataSource
import rs.raf.vezbe9.data.models.domain.Employee

class EmployeeRepositoryImpl(private val employeeDataSource: EmployeeDataSource) : EmployeeRepository {

    override fun getEmployees(): Observable<List<Employee>> {
        return employeeDataSource
            .getEmployees()
            .map {
                it.data.map {
                    Employee(
                        it.id,
                        it.name,
                        it.salary,
                        it.age
                    )
                }
            }
    }

}