package rs.raf.vezbe9.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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
        /* DOHVATANJE SVIH ZAPOSLENIH */
        mainViewModel.employees.observe(this, Observer {
            Timber.e("Got employees $it")
            // Kada dobijemo listu svih korisnika sa servera, hocemo da dohvatimo posebno
            // podatke o prvom zaposlenom
            /* API NE RADI !!! */
            mainViewModel.getEmployee(it[0].id)
        })
        //mainViewModel.getEmployees()

        /* DOHVATANJE JENDOG ZAPOSLENOG NA OSNOVU ID-A */
        mainViewModel.employee.observe(this, Observer {
            Timber.e("Got employee $it")
        })

        /* DODAVANJE NOVOG ZAPOSLENOG */
        mainViewModel.employeeAdded.observe(this, Observer {
            Timber.e("Added employee $it")
        })
        // mainViewModel.addEmployee("draza", "666999", "35")

        /* MENJANJE PODATAKA ZAPOSLENOG */
        mainViewModel.employeeUpdated.observe(this, Observer {
            Timber.e("Updated employee $it")
        })
        // mainViewModel.updateEmployee("35", "mika", "1", "33")

        /* BRISANJE ZAPOSLENOG */
        mainViewModel.employeeDeleted.observe(this, Observer {
            Timber.e("Employee deleted $it")
        })
        /* API NE RADI !!! */
        mainViewModel.delete("35")

    }
}
