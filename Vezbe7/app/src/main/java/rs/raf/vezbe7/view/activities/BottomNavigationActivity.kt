package rs.raf.vezbe7.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import rs.raf.vezbe7.R
import rs.raf.vezbe7.view.viewpager.PagerAdapter

class BottomNavigationActivity : AppCompatActivity(R.layout.activity_bottom_navigation) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_1 ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false)
                }
                R.id.navigation_2 ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_2, false)
                }
                R.id.navigation_3 ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_3, false)
                }
            }
            true
        }
    }
}
