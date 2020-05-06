package rs.raf.vezbe9.data.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import rs.raf.vezbe9.data.models.api.EmployeesResponse
import rs.raf.vezbe9.data.models.api.SingleEmployeeResponse

interface EmployeeDataSource {

    @GET("employees")
    fun getEmployees() : Observable<EmployeesResponse>

    /* Api doesn't work */
    @GET("employee/{id}")
    fun getEmployee(@Path("id") id: String): Observable<SingleEmployeeResponse>

}