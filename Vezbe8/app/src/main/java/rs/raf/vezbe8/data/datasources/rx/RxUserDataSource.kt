package rs.raf.vezbe8.data.datasources.rx

import io.reactivex.Observable
import rs.raf.vezbe8.data.entities.UserData

interface RxUserDataSource {
    fun getUserData(): Observable<UserData>
}