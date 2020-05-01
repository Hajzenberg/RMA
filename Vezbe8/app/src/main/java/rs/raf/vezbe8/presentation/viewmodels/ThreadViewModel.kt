package rs.raf.vezbe8.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.vezbe8.presentation.contracts.ThreadContract

class ThreadViewModel : ViewModel(), ThreadContract.ViewModel {

    override val data: MutableLiveData<String> = MutableLiveData()

    override fun updateData(text: String) {
        data.value = text
    }


}