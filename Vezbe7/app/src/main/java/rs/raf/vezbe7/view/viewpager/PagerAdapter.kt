package rs.raf.vezbe7.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.vezbe7.view.fragments.FirstFragment
import rs.raf.vezbe7.view.fragments.SecondFragment
import rs.raf.vezbe7.view.fragments.ThirdFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> FirstFragment()
            FRAGMENT_2 -> SecondFragment()
            else -> ThirdFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_1 -> "1"
            FRAGMENT_2 -> "2"
            else -> "3"
        }
    }

}