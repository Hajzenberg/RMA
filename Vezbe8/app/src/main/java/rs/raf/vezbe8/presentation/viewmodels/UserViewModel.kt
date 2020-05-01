package rs.raf.vezbe8.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.vezbe8.data.entities.User
import rs.raf.vezbe8.data.repositories.UserRepository
import rs.raf.vezbe8.presentation.contracts.UserContract

class UserViewModel(private val userRepository: UserRepository) : ViewModel(), UserContract.ViewModel {

    override val user: MutableLiveData<User> = MutableLiveData()

    override fun getUser() {
        user.value = userRepository.getUser()
    }


}