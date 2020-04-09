package rs.raf.vezbe7.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe7.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        staticBtn.setOnClickListener {
            val intent = Intent(this, StaticFragmentActivity::class.java)
            startActivity(intent)
        }
        addFragmentBtn.setOnClickListener {
            val intent = Intent(this, AddFragmentActivity::class.java)
            startActivity(intent)
        }
        replaceFragmentBtn.setOnClickListener {
            val intent = Intent(this, ReplaceFragmentActivity::class.java)
            startActivity(intent)
        }
        fragmentInFragmentBtn.setOnClickListener {
            val intent = Intent(this, FragmentInFragmentActivity::class.java)
            startActivity(intent)
        }
        fragmentCommunicationBtn.setOnClickListener {
            val intent = Intent(this, FragmentCommunicationActivity::class.java)
            startActivity(intent)
        }
        tabsBtn.setOnClickListener {
            val intent = Intent(this, TabsActivity::class.java)
            startActivity(intent)
        }
        bottomBarBtn.setOnClickListener {
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}
