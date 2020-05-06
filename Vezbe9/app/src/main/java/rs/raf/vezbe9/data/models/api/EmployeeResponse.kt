package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeeResponse(
    val id: String,
    @Json(name = "employee_name") val name: String,
    @Json(name = "employee_salary") val salary: String,
    @Json(name = "employee_age") val age: String,
    @Json(name = "profile_image") val profileImage: String
)