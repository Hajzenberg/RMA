package rs.raf.vezbe8.data.datasources

import rs.raf.vezbe8.data.entities.UserData

interface UserDataSource {
    fun getUserData(): UserData
}