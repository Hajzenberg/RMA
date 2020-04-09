package rs.raf.vezbe7.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_input.*
import rs.raf.vezbe7.R
import rs.raf.vezbe7.viewmodels.SharedViewModel

class InputFragment : Fragment(R.layout.fragment_input) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        storeBtn.setOnClickListener {
            val userInput = inputEt.text.toString()
            sharedViewModel.storeUserInput(userInput)
        }
    }

}