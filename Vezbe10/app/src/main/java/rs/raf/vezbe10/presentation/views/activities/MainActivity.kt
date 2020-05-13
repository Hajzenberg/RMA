package rs.raf.vezbe10.presentation.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.vezbe10.R
import rs.raf.vezbe10.data.local.models.Student
import rs.raf.vezbe10.presentation.contract.MainContract
import rs.raf.vezbe10.presentation.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        
    }
}
