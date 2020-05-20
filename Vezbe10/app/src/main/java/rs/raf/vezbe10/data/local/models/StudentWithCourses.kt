package rs.raf.vezbe10.data.local.models

import androidx.room.Embedded
import androidx.room.Relation

data class StudentWithCourses(
    @Embedded val studentEntity: StudentEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "student_id"
    )
    val courses: List<CourseEntity>?
)