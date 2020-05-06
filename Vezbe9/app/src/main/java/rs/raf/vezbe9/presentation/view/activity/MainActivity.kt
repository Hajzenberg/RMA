package rs.raf.vezbe9.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rs.raf.vezbe9.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

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
