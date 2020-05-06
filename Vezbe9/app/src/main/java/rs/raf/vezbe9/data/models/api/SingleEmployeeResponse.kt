package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SingleEmployeeResponse(
    val status: String,
    val data: EmployeeResponse
)