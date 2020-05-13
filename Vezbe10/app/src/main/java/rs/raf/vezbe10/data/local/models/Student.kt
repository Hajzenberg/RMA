package rs.raf.vezbe10.data.local.models

import java.util.*

data class Student(
    val name: String,
    val city: String,
    val street: String,
    val number: String,
    val dateOfBirth: Date,
    val subjects: List<String>
)