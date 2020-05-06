package rs.raf.vezbe8.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.vezbe8.data.entities.User
import rs.raf.vezbe8.data.repositories.rx.RxUserRepository
import rs.raf.vezbe8.presentation.contracts.UserContract
import timber.log.Timber

class RxUserViewModel(private val userRepository: RxUserRepository) : ViewModel(), UserContract.ViewModel {

    override val user: MutableLiveData<User> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun getUser() {
        val subscription = userRepository
            .getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    user.value = it
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("On complete")
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        subscriptions.dispose()
        super.onCleared()
    }
}