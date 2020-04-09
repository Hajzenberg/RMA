package rs.raf.vezbe7.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rs.raf.vezbe7.R
import rs.raf.vezbe7.view.fragments.FirstFragment

class AddFragmentActivity : AppCompatActivity(R.layout.activity_add_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initFragment()
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.addFragmentFcv, FirstFragment())
        transaction.commit()
    }
}
