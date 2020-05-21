package rs.raf.vezbe11.presentation.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_input.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.vezbe11.R
import rs.raf.vezbe11.data.models.Movie
import rs.raf.vezbe11.presentation.contract.MainContract
import rs.raf.vezbe11.presentation.viewmodel.MainViewModel

class InputFragment : Fragment(R.layout.fragment_input) {

    // Koristimo by sharedViewModel jer sada view modele instanciramo kroz koin
    private val mainViewModel: MainContract.ViewModel by sharedViewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        addBtn.setOnClickListener {
            val input = inputEt.text.toString()
            val movieToAdd = Movie(id = input, title = input)
            mainViewModel.addMovie(movieToAdd)
        }
    }

    private fun initObservers() {
        mainViewModel.addDone.observe(viewLifecycleOwner, Observer {
            val message = if (it) "Movie added" else "Error happened"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })
    }

}