package rs.raf.vezbe8.presentation.contracts

import androidx.lifecycle.LiveData

interface ThreadContract {

    interface ViewModel {

        val data: LiveData<String>

        fun updateData(text: String)

    }

}