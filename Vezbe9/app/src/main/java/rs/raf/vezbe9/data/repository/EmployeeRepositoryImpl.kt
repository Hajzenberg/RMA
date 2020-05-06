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

    override fun getEmployee(id: String): Observable<Employee> {
        return employeeDataSource
            .getEmployee(id)
            .map {
                val employeeResponse = it.data
                Employee(
                    employeeResponse.id,
                    employeeResponse.name,
                    employeeResponse.salary,
                    employeeResponse.age
                )
            }
    }

}