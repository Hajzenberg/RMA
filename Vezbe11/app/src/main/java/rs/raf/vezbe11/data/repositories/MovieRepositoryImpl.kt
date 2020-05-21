package rs.raf.vezbe11.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.vezbe11.data.datasources.local.MovieDao
import rs.raf.vezbe11.data.datasources.remote.MovieService
import rs.raf.vezbe11.data.models.Movie
import rs.raf.vezbe11.data.models.MovieEntity
import rs.raf.vezbe11.data.models.Resource
import timber.log.Timber

class MovieRepositoryImpl(
    private val localDataSource: MovieDao,
    private val remoteDataSource: MovieService
) : MovieRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext {
                Timber.e("Upis u bazu")
                val entities = it.map {
                    MovieEntity(
                        it.id,
                        it.title,
                        it.description
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
        // Kada zelimo sami da kontrolisemo sta se desava sa greskom, umesto da je samo prepustimo
        // error handleru, mozemo iskoristiti operator onErrorReturn, tada sami na osnovu greske
        // odlucujemo koju vrednost cemo da vratimo. Ta vrednost mora biti u skladu sa povratnom
        // vrednoscu lanca.
        // Kada se iskoristi onErrorReturn onError lambda u viewmodelu nece biti izvrsena,
        // nego ce umesdto nje biti izvsena onNext koja ce kao parametar primiti vrednost koja
        // je vracena iz onErrorReturn
        // Obicno se koristi kada je potrebno proveriti koji kod greske je vratio server.
//            .onErrorReturn {
//                when(it) {
//                    is HttpException -> {
//                        when(it.code()) {
//                            in 400..499 -> {
//
//                            }
//                        }
//                    }
//                }
//                Timber.e("ON ERROR RETURN")
//            }
    }

    override fun getAll(): Observable<List<Movie>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Movie(it.id, it.title)
                }
            }
    }

    override fun getAllByName(name: String): Observable<List<Movie>> {
        return localDataSource
            .getByName(name)
            .map {
                it.map {
                    Movie(it.id, it.title)
                }
            }
    }

    override fun insert(movie: Movie): Completable {
        val movieEntity = MovieEntity(movie.id, movie.title, "")
        return localDataSource
            .insert(movieEntity)
    }

}