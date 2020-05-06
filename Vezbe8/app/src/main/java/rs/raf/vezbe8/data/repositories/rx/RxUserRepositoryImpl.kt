package rs.raf.vezbe8.data.repositories.rx

import io.reactivex.Observable
import rs.raf.vezbe8.data.datasources.rx.RxUserDataSource
import rs.raf.vezbe8.data.entities.User
import rs.raf.vezbe8.data.entities.toUser

class RxUserRepositoryImpl(private val userDataSource: RxUserDataSource) :
    RxUserRepository {

    override fun getUser(): Observable<User> {
        return userDataSource
            .getUserData()
            .map {
                it.toUser()
            }
    }

}