package rs.raf.vezbe7.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowViewModel : ViewModel() {

    private val titleLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        titleLiveData.value = "This is a placeholder!"
    }

    fun getTitle() : LiveData<String> {
        return titleLiveData
    }

}