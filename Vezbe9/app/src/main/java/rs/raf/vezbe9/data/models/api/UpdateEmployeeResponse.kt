package rs.raf.vezbe9.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateEmployeeResponse(
    val status: String,
    val data: ShortEmployeeResponse?,
    val message: String?
)