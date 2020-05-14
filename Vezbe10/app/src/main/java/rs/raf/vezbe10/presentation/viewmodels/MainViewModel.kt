package rs.raf.vezbe10.presentation.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.vezbe10.data.local.models.CourseEntity
import rs.raf.vezbe10.data.local.models.StudentEntity
import rs.raf.vezbe10.data.local.repository.CourseRepository
import rs.raf.vezbe10.data.local.repository.StudentRepository
import rs.raf.vezbe10.presentation.contract.MainContract
import timber.log.Timber

class MainViewModel(
    private val studentRepository: StudentRepository,
    private val courseRepository: CourseRepository
) : ViewModel(), MainContract.ViewModel {

    private val subscriptions = CompositeDisposable()

    override fun insertStudent(studentEntity: StudentEntity) {
        val subscription = studentRepository
            .insert(studentEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun insertStudents(studentEntities: List<StudentEntity>) {
        val subscription = studentRepository
            .insertAll(studentEntities)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("INSERTED STUDENTS WITH IDs:  $it")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllStudents() {
        val subscription = studentRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("$it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun updateStudentNameById(id: Long, name: String) {
        val subscription = studentRepository
            .updateNameById(id, name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("UPDATED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun updateStudentNameById2(id: Long, name: String) {
        val subscription = studentRepository
            .updateNameById2(id, name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("UPDATED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteAllStudents() {
        val subscription = studentRepository
            .deleteAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllStudentsWithNameAndCity() {
        val subscription = studentRepository
            .getAllWithNameAndCityOnly()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("$it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun insertCourse(courseEntity: CourseEntity) {
        val subscription = courseRepository
            .insert(courseEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("INSERTED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllStudentsWithClasses() {
        val subscription = studentRepository
            .getAllWithClasses()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("$it")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }


    override fun onCleared() {
        subscriptions.clear()
        super.onCleared()
    }


}