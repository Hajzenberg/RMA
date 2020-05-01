package rs.raf.vezbe8.data.repositories

import rs.raf.vezbe8.data.datasources.UserDataSource
import rs.raf.vezbe8.data.entities.User
import rs.raf.vezbe8.data.entities.toUser

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override fun getUser(): User {
        return userDataSource.getUserData().toUser()
    }

}