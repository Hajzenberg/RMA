package rs.raf.vezbe6.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_classic_recycler.*
import rs.raf.vezbe6.R
import rs.raf.vezbe6.view.recycler.adapter.CarAdapter
import rs.raf.vezbe6.view.recycler.diff.CarDiffItemCallback
import rs.raf.vezbe6.viewmodel.RecyclerViewModel

class RecyclerActivity : AppCompatActivity(R.layout.activity_classic_recycler) {

    private val recyclerViewModel: RecyclerViewModel by viewModels()

    private lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initListeners()
        initRecycler()
    }

    private fun initListeners() {
        inputEt.doAfterTextChanged {
            recyclerViewModel.filterCars(it.toString())
        }
        doMagicBtn.setOnClickListener {
            recyclerViewModel.addCar(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR9vMHQzf3GMYiI2WnYG9TUKnGAQFevruSgJF35VLAJe_odBMVd&usqp=CAU",
                "Ikea",
                "LILLABO"
            )
        }
    }

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(this)
        carAdapter = CarAdapter(CarDiffItemCallback()) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
        listRv.adapter = carAdapter
    }

    private fun initObservers() {
        recyclerViewModel.getCars().observe(this, Observer {
            carAdapter.submitList(it)
        })
    }
}
