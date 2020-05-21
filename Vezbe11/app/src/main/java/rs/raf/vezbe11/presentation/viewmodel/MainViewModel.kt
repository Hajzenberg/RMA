package rs.raf.vezbe11.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.vezbe11.data.models.Movie
import rs.raf.vezbe11.data.repositories.MovieRepository
import rs.raf.vezbe11.presentation.contract.MainContract
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), MainContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    override val addDone: MutableLiveData<Boolean> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    init {
        val contactsDisposable = publishSubject
            .debounce(200, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap {
                movieRepository
                    .getAllByName(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        Timber.e("Error in publish subject")
                        Timber.e(it)
                    }
            }
            .subscribe(
                {
                    movies.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(contactsDisposable)
    }

    override fun fetchAllMovies() {
        val subscription = movieRepository
            .fetchAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Movies fetched from internet")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllMovies() {
        val subscription = movieRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    movies.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getMoviesByName(name: String) {
        publishSubject.onNext(name)
    }

    override fun addMovie(movie: Movie) {
        val subscription = movieRepository
            .insert(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Movie inserted")
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