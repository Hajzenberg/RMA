package rs.raf.vezbe10.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "students")
data class StudentEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var city: String,
    var street: String,
    var number: String,
    @ColumnInfo(name = "date_of_birth")var dateOfBirth: Date = Date(),
    // Ako zelimo da izbegnemo pravljenje nove tabele za one to many relacije, mozemo u entitetu
    // cuvati json liste objekata. Treba dobro razmisliti u odabiru izmedju ove dve opcije, jer
    // svaka ima prednosti i mane.
    var subjects: List<String> = listOf()
)