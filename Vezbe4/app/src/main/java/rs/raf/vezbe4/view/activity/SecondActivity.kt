package rs.raf.vezbe4.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import rs.raf.vezbe4.R
import timber.log.Timber

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    companion object {
        // Kako ne bi doslo do bagova zbog gresaka u kucanju, dobra praksa je da se
        // kljkucevi pod kojima se salju vrednosti stave u konstante. Takodje, konstanta
        // bi trebalo da bude definisan u activity-u koji prima poruku.
        const val MESSAGE_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        intent?.let {
            val message = it.getStringExtra(MESSAGE_KEY)
            // prikazimo poruku na textView-u
            messageTv.text = message
            // prikazimo poruku u konzoli pomocu timbera (kliknite na tab Run na samom dnu prozora)
            Timber.e(message)
        }

        messageTv.setOnClickListener {
            // Kada korisnik klikne na poruku na ovom activity-u zelimo da ga zavrsimo
            // i vratimo se na MainActivity
            finish()
        }
    }

}