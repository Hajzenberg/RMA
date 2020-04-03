package rs.raf.vezbe6.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_rotation.*
import rs.raf.vezbe6.R
import rs.raf.vezbe6.viewmodel.RotationViewModel
import timber.log.Timber

class RotationActivity : AppCompatActivity(R.layout.activity_rotation) {

    companion object {
        const val MESSAGE_KEY = "message"
    }

    private val rotationViewModel: RotationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        setTextBtn.setOnClickListener {
            val message = inputEt.text.toString()
            // Kada korisink klikne na dugme string cuvamo u viewmodelu u livedata objektu.
            rotationViewModel.setMessage(message)
        }
    }

    private fun initObservers() {
        rotationViewModel.getMessage().observe(this, Observer {
            // Svaki put kada se vrednost koju cuva livedata, ovaj observer ce biti obavesten
            // tako da mozemo apdejtovati tekst na ekranu
            messageTv.text = it
        })
    }

    /* Zakomentarisano jer koristimo ViewModel i LiveData, ali je bitno znati zbog process death-a */

    // Ukoliko sistem unisti nasu aplikaciju zbog nedostatka memorije,
    // unistice se i trenutni activity. Jedan nacin da sacuvamo trenutne
    // vrednosti jeste da ih sacuvamo u bundle i procitamo u onRestoreInstanceState().
    // Ovaj nacin cuvanja podataka ima prednost u odnosu na ViewModel jer pored
    // konfiguracionih promena prezivaljava i process death.
//    override fun onSaveInstanceState(outState: Bundle) {
//        val message = inputEt.text.toString()
//        outState.putString(MESSAGE_KEY, message)
//        super.onSaveInstanceState(outState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        val message = savedInstanceState.getString(MESSAGE_KEY)
//        messageTv.text = message
//    }
}
