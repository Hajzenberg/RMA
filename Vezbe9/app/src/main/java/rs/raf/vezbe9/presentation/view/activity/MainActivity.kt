package rs.raf.vezbe9.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.vezbe9.R
import rs.raf.vezbe9.presentation.contract.MainContract
import rs.raf.vezbe9.presentation.viewmodel.MainViewModel
import timber.log.Timber

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
        mainViewModel.employees.observe(this, Observer {
            Timber.e(it.toString())
            // Kada dobijemo listu svih korisnika sa servera, hocemo da dohvatimo posebno
            // podatke o prvom zaposlenom
            mainViewModel.getEmployee(it[0].id)
        })
        mainViewModel.getEmployees()
        mainViewModel.employee.observe(this, Observer {
            Timber.e(it.toString())
        })
    }
}
