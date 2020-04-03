package rs.raf.vezbe6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RotationViewModel : ViewModel() {

    private var message: MutableLiveData<String> = MutableLiveData()

    fun getMessage() : LiveData<String> {
        return message
    }

    fun setMessage(messageText: String) {
        message.value = messageText
    }
}