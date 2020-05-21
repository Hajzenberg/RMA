package rs.raf.vezbe11.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.vezbe11.R
import rs.raf.vezbe11.presentation.contract.MainContract
import rs.raf.vezbe11.presentation.view.recycler.adapter.MovieAdapter
import rs.raf.vezbe11.presentation.viewmodel.MainViewModel
import timber.log.Timber

class ListFragment : Fragment(R.layout.fragment_list) {

    // Koristimo by sharedViewModel jer sada view modele instanciramo kroz koin
    private val mainViewModel: MainContract.ViewModel by sharedViewModel<MainViewModel>()

    private lateinit var adapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initRecycler()
        initListeners()
    }

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(context)
        adapter = MovieAdapter()
        listRv.adapter = adapter
    }

    private fun initListeners() {
        inputEt.doAfterTextChanged {
            val filter = it.toString()
            mainViewModel.getMoviesByName(filter)
        }
    }

    private fun initObservers() {
        mainViewModel.movies.observe(viewLifecycleOwner, Observer {
            Timber.e("FRAGMENT ${it}")
            adapter.submitList(it)
        })
        // Pravimo subscription kad observablu koji je vezan za getAll iz baze
        // Na svaku promenu tabele, obserrvable ce emitovati na onNext sve elemente
        // koji zadovoljavaju query
        mainViewModel.getAllMovies()
        // Pokrecemo operaciju dovlacenja podataka sa servera, kada podaci stignu,
        // bice sacuvani u bazi, tada ce se triggerovati observable na koji smo se pretplatili
        // preko metode getAllMovies()
        mainViewModel.fetchAllMovies()
    }

}