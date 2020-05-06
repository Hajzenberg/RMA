package rs.raf.vezbe8.data.repositories.rx

import io.reactivex.Observable
import rs.raf.vezbe8.data.entities.User

interface RxUserRepository {
    fun getUser(): Observable<User>
}