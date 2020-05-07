package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShortEmployeeResponse(
    val id: String,
    val name: String,
    val salary: String,
    val age: String
)