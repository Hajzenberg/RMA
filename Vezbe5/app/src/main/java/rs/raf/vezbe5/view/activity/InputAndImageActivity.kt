package rs.raf.vezbe5.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_input_and_image.*
import rs.raf.vezbe5.R
import timber.log.Timber

class InputAndImageActivity : AppCompatActivity(R.layout.activity_input_and_image) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        // Ucitavamo sliku sa url-a u imageView
        Picasso
            .get()
            .load("https://picsum.photos/600")
            .placeholder(R.drawable.ic_autorenew_black_24dp)
            .error(R.drawable.ic_error_outline_black_24dp)
            .into(imageIv)

        // Dodajemo listener kojim pratimo unos korisnika u editText
        inputEt.doAfterTextChanged {
            // Ispisujemo sadrzaj u konzolu. Obratite paznju da ne dobijamo string, nego
            // editable koji moramo pretvoriti u string pre ispisa
            Timber.e(it.toString())
        }

        showInputContentBtn.setOnClickListener {
            // Uzimamo trenutni sadrzaj koji je korisnik uneo u editText i cuvamo ga kao string
            val userInput = inputEt.text.toString()
            // Ispisujemo sadrzaj u toast-u
            Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener {
            // Vracamo se na pretodni activity
            finish()
        }
    }
}
