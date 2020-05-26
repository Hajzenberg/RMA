package rs.raf.vezbe11.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.vezbe11.data.models.Movie
import rs.raf.vezbe11.data.models.Resource
import rs.raf.vezbe11.data.repositories.MovieRepository
import rs.raf.vezbe11.presentation.contract.MainContract
import rs.raf.vezbe11.presentation.view.states.AddMovieState
import rs.raf.vezbe11.presentation.view.states.MoviesState
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), MainContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val moviesState: MutableLiveData<MoviesState> = MutableLiveData()
    override val addDone: MutableLiveData<AddMovieState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    init {
        val subscription = publishSubject
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
                    moviesState.value = MoviesState.Success(it)
                },
                {
                    moviesState.value = MoviesState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun fetchAllMovies() {
        val subscription = movieRepository
            .fetchAll()
            .startWith(Resource.Loading()) //Kada se pokrene fetch hocemo da postavimo stanje na Loading
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is Resource.Loading -> moviesState.value = MoviesState.Loading
                        is Resource.Success -> moviesState.value = MoviesState.DataFetched
                        is Resource.Error -> moviesState.value = MoviesState.Error("Error happened while fetching data from the server")
                    }
                },
                {
                    moviesState.value = MoviesState.Error("Error happened while fetching data from the server")
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
                    moviesState.value = MoviesState.Success(it)
                },
                {
                    moviesState.value = MoviesState.Error("Error happened while fetching data from db")
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
                    addDone.value = AddMovieState.Success
                },
                {
                    addDone.value = AddMovieState.Error("Error happened while adding movie")
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