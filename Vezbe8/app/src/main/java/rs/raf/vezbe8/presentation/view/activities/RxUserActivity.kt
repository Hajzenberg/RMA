package rs.raf.vezbe8.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.vezbe8.R
import rs.raf.vezbe8.presentation.contracts.UserContract
import rs.raf.vezbe8.presentation.viewmodels.RxUserViewModel

class RxUserActivity : AppCompatActivity(R.layout.activity_user) {

    private val userViewModel: UserContract.ViewModel by viewModel<RxUserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        userViewModel.user.observe(this, Observer {
            userTv.text = it.name
        })
        userViewModel.getUser()
    }

}