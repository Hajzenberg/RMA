package rs.raf.vezbe7.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import rs.raf.vezbe7.R
import timber.log.Timber

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("ON CREATE")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.e("ON CREATE VIEW")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("ON VIEW CREATED")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.e("ON DESTROY VIEW")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("ON DESTROY")
    }

}