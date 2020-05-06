package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeesResponse(
    val status: String,
    val data: List<EmployeeResponse>
)