package rs.raf.vezbe7.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val userInputLiveData : MutableLiveData<String> = MutableLiveData()

    fun getUserInput() : LiveData<String> {
        return userInputLiveData
    }

    fun storeUserInput(userInput : String) {
        userInputLiveData.value = userInput
    }

}