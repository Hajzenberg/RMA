package rs.raf.vezbe7.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_replace_fragment.*
import rs.raf.vezbe7.R
import rs.raf.vezbe7.view.fragments.FirstFragment
import rs.raf.vezbe7.view.fragments.SecondFragment

class ReplaceFragmentActivity : AppCompatActivity(R.layout.activity_replace_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initFragment()
        initListeners()
    }

    private fun initListeners() {
        replaceFragmentBtn.setOnClickListener {
            val transaction = createTransactionWithAnimation()
            transaction.replace(R.id.replaceFargmentFcv, SecondFragment())
            transaction.commit()
        }
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.replaceFargmentFcv, FirstFragment())
        transaction.commit()
    }

    private fun createTransactionWithAnimation(): FragmentTransaction {
        val transaction =  supportFragmentManager.beginTransaction()
        // Dodajemo animaciju kada se fragment doda
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
        // Dodajemo transakciju na backstack kako bi se pritisokm na back transakcija rollback-ovala
        transaction.addToBackStack(null)
        return transaction
    }
}
