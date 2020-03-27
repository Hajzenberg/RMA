package rs.raf.vezbe5.view.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_preference.*
import rs.raf.vezbe5.R

class PreferenceActivity : AppCompatActivity(R.layout.activity_preference) {

    companion object {
        const val PREF_MESSAGE_KEY = "prefMessageKey"
    }

    private var messageWritten = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        storeBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(PREF_MESSAGE_KEY, "Secret pref message")
            editor.apply()
            messageWritten = true
            Toast.makeText(this, "Message written to preferences", Toast.LENGTH_SHORT).show()
        }
        backBtn.setOnClickListener {
            val result = if (messageWritten) Activity.RESULT_OK else Activity.RESULT_CANCELED
            setResult(result)
            finish()
        }
    }

    // Ne zelimo da dozvolimo korisniku da se vrati pritiskom na back
    // Ukoliko bismo dozvolili korisniku da klikne na back logiku sa setovanjem
    // rezultata bismo morali da preselimo u nasu implementaciju finish() metode
    // u kojoj bismo pozivali setResult() pre poziva super.finish()
    override fun onBackPressed() {
        Toast.makeText(this, "Back press disabled", Toast.LENGTH_SHORT).show()
    }
}
