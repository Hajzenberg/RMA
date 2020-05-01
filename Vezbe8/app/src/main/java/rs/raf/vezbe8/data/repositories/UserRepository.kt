package rs.raf.vezbe8.data.repositories

import rs.raf.vezbe8.data.entities.User

interface UserRepository {
    fun getUser(): User
}