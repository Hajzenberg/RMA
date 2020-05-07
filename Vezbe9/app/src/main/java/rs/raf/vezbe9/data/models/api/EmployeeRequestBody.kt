package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeeRequestBody(
    val name: String?,
    val salary: String?,
    val age: String?
)