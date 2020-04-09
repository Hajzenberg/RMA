package rs.raf.vezbe7.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import rs.raf.vezbe7.R

class OuterFragment : Fragment(R.layout.fragment_outer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initInnerFragment()
    }

    private fun initInnerFragment() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.outerFragmentFcv, FirstFragment())
        transaction.commit()
    }

}