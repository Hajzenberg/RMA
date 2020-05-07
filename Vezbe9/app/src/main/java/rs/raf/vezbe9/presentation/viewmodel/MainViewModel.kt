package rs.raf.vezbe9.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.vezbe9.data.models.domain.Employee
import rs.raf.vezbe9.data.repository.EmployeeRepository
import rs.raf.vezbe9.presentation.contract.MainContract
import timber.log.Timber

class MainViewModel(
    private val employeeRepository: EmployeeRepository
) : ViewModel(), MainContract.ViewModel {

    override val employees: MutableLiveData<List<Employee>> = MutableLiveData()
    override val employee: MutableLiveData<Employee> = MutableLiveData()
    override val employeeAdded: MutableLiveData<Employee> = MutableLiveData()
    override val employeeUpdated: MutableLiveData<String> = MutableLiveData()
    override val employeeDeleted: MutableLiveData<String> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun getEmployees() {
       val subscription = employeeRepository
           .getEmployees()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(
               {
                   employees.value = it
               },
               {
                   Timber.e(it)
               }
           )
        subscriptions.add(subscription)
    }

    override fun getEmployee(id: String) {
        val subscription = employeeRepository
            .getEmployee(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    employee.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun addEmployee(name: String, salary: String, age: String) {
        val subscription = employeeRepository
            .addEmployee(name, salary, age)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    employeeAdded.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun updateEmployee(id: String, name: String?, salary: String?, age: String?) {
        val subscription = employeeRepository
            .updateEmployee(id, name, salary, age)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    employeeUpdated.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun delete(id: String) {
        val subscription = employeeRepository
            .delete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    employeeDeleted.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}