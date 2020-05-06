package rs.raf.vezbe9.data.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.vezbe9.data.models.api.EmployeesResponse

interface EmployeeDataSource {

    @GET("employees")
    fun getEmployees() : Observable<EmployeesResponse>

}