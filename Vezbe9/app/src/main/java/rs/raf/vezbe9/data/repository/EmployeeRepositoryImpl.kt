package rs.raf.vezbe9.data.repository

import io.reactivex.Observable
import rs.raf.vezbe9.data.datasources.EmployeeDataSource
import rs.raf.vezbe9.data.models.api.EmployeeRequestBody
import rs.raf.vezbe9.data.models.domain.Employee

class EmployeeRepositoryImpl(private val employeeDataSource: EmployeeDataSource) : EmployeeRepository {

    override fun getEmployees(): Observable<List<Employee>> {
        return employeeDataSource
            .getAll()
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
            .getById(id)
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

    override fun addEmployee(name: String, salary: String, age: String): Observable<Employee> {
        val body = EmployeeRequestBody(name, salary, age)
        return employeeDataSource
            .add(body)
            .map {
                val shortEmployeeResponse = it.data!!
                Employee(
                    shortEmployeeResponse.id,
                    shortEmployeeResponse.name,
                    shortEmployeeResponse.salary,
                    shortEmployeeResponse.age
                )
            }
    }

    override fun updateEmployee(id: String, name: String?, salary: String?, age: String?): Observable<String> {
        val body = EmployeeRequestBody(name, salary, age)
        return employeeDataSource
            .update(id, body)
            .map {
                it.status
            }
    }

    override fun delete(id: String): Observable<String> {
        return employeeDataSource
            .delete(id)
            .map {
                it.status
            }
    }

}