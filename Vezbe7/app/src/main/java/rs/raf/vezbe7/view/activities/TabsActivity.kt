package rs.raf.vezbe7.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabs.*
import rs.raf.vezbe7.R
import rs.raf.vezbe7.view.viewpager.PagerAdapter

class TabsActivity : AppCompatActivity(R.layout.activity_tabs) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
