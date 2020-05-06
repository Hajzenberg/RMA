package rs.raf.vezbe9.presentation.viewmodel

import androidx.lifecycle.LiveData
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

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}