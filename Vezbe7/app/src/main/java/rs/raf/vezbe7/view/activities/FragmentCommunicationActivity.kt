package rs.raf.vezbe7.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rs.raf.vezbe7.R
import rs.raf.vezbe7.view.fragments.InputFragment
import rs.raf.vezbe7.view.fragments.ShowFragment

class FragmentCommunicationActivity : AppCompatActivity(R.layout.activity_fragment_communication) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initFragments()
    }

    private fun initFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.topFcv, ShowFragment())
        transaction.add(R.id.bottomFcv, InputFragment())
        transaction.commit()
    }
}