package rs.raf.vezbe7.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_show.*
import rs.raf.vezbe7.R
import rs.raf.vezbe7.viewmodels.SharedViewModel
import rs.raf.vezbe7.viewmodels.ShowViewModel

class ShowFragment : Fragment(R.layout.fragment_show) {

    private val showViewModel: ShowViewModel by viewModels()

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        // Pre nego sto korisnik unese tekst, zelimo da prikazemo placeholder tekst
        showViewModel.getTitle().observe(viewLifecycleOwner, Observer {
            showTv.text = it
        })
        // Kada korisnik unese tekst i potvrdi unos, zelimo da prikazemo taj unos
        sharedViewModel.getUserInput().observe(viewLifecycleOwner, Observer {
            showTv.text = it
        })
    }

}