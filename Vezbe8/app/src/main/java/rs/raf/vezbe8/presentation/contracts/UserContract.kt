package rs.raf.vezbe8.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.vezbe8.data.entities.User

interface UserContract {

    interface ViewModel {

        val user: LiveData<User>

        fun getUser()

    }

}