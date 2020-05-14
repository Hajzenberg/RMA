package rs.raf.vezbe10.data.local.datasources

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.vezbe10.data.local.models.StudentEntity
import rs.raf.vezbe10.data.local.models.StudentNameAndCity
import rs.raf.vezbe10.data.local.models.StudentWithClasses

@Dao
abstract class StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertStudent(studentEntity: StudentEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertStudents(studentEntity: List<StudentEntity>): Single<List<Long>> // Moze da vrati i Completable

    @Query("SELECT * FROM students")
    abstract fun getAll(): Observable<List<StudentEntity>>

    @Query("SELECT * FROM students WHERE id == :id")
    abstract fun getById(id: Long): StudentEntity

    // Pogledati komentar za delete metodu
    @Update
    abstract fun update(studentEntity: StudentEntity)

    // Pogledati komentar za deleteById metodu
    @Query("UPDATE students SET name = :name WHERE id == :id")
    abstract fun updateNameById(id: Long, name: String): Completable

    @Delete
    abstract fun delete(studentEntity: StudentEntity)

    // Ova metoda se manje uklapa u ceo koncept kada radimo sa ORM-om, ali radi
    // identicnu stvar kao metoda iznad
    @Query("DELETE FROM students WHERE id == :id")
    abstract fun deleteById(id: Long)

    @Query("DELETE FROM students")
    abstract fun deleteAll(): Completable

    // Sve sto se uradi u okviru metode anotirane sa @Transaction
    // se tretira kao jedna transakcija
    // https://en.wikipedia.org/wiki/Atomicity_(database_systems)
    @Transaction
    open fun getByIdAndUpdate(id: Long, name: String) {
        val student = getById(id)
        val updatedStudent = student.copy(
            name = name
        )
        update(updatedStudent)
    }

    @Query("SELECT name, city FROM students")
    abstract fun getAllWithNameAndCityOnly(): Observable<List<StudentNameAndCity>>

    @Transaction //Kada vracamo objekte koji su u relaciji, preporuceno je da anotiramo metodu sa @Transaction
    @Query("SELECT * FROM students")
    abstract fun getAllWIthClasses(): Observable<List<StudentWithClasses>>
}