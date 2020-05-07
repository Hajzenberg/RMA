package rs.raf.vezbe9.data.datasources

import io.reactivex.Observable
import retrofit2.http.*
import rs.raf.vezbe9.data.models.api.*

interface EmployeeDataSource {

    @GET("employees")
    fun getAll() : Observable<EmployeesResponse>

    /* API NE RADI !!! */
    @GET("employee/{id}")
    fun getById(@Path("id") id: String): Observable<SingleEmployeeResponse>

    @POST("create")
    fun add(@Body body: EmployeeRequestBody): Observable<UpdateEmployeeResponse>

    @PUT("update/{id}")
    fun update(@Path("id") id: String, @Body body: EmployeeRequestBody): Observable<UpdateEmployeeResponse>

    @DELETE("delete/{id}")
    fun delete(): Observable<UpdateEmployeeResponse>

}