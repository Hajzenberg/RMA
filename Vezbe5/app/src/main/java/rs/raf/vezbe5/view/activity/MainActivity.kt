package rs.raf.vezbe5.view.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe5.R
import rs.raf.vezbe5.models.Student

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        const val STUDENT_RECEIVED_REQUEST_CODE = 111
        const val STUDENT_RECEIVED_MESSAGE = "studentReceivedKey"
        const val PREFERENCE_WRITE_REQUEST_CODE = 222
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            STUDENT_RECEIVED_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val message = data?.getStringExtra(STUDENT_RECEIVED_MESSAGE) ?: "Error"
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error happened", Toast.LENGTH_SHORT).show()
                }
            }
            PREFERENCE_WRITE_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    // Neka vrednost je bila upisana na PreferenceActivity-u, proveravamo koja
                    val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                    val message = sharedPreferences.getString(PreferenceActivity.PREF_MESSAGE_KEY, "") ?: ""
                    Toast.makeText(this, "We have written to pref: $message", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Nothing was written", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        startStudentActivityForResultBtn.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            // Prosledjujemo objekat klase Student
            // Zakomentarisite dodavanje studenta u intent i primetite razliku
            intent.putExtra(StudentActivity.STUDENT_KEY, Student("Rafovac"))
            startActivityForResult(intent, STUDENT_RECEIVED_REQUEST_CODE)
        }

        startPreferenceActivityForResultBtn.setOnClickListener {
            // Ukoliko smo vec jednom upisali vrednost na PreferenceActivity-u,
            // ne zelimo vise nikad da je upisemo. Korisnik moze da pocisti
            // SharedPreferences ako u podesavanjima aplikacije clear-uje storage.

            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            val message = sharedPreferences.getString(PreferenceActivity.PREF_MESSAGE_KEY, null)

            if (message == null) {
                // Nista jos uvek nije upisano, pokreni PreferenceActivity
                val intent = Intent(this, PreferenceActivity::class.java)
                startActivityForResult(intent, PREFERENCE_WRITE_REQUEST_CODE)
            } else {
                // Nesto je ranije upisano, nemoj otvarati PreferenceActivity
                Toast.makeText(this, "You can't write to preference anymore :(", Toast.LENGTH_SHORT).show()
            }
        }

        inputAndImageBtn.setOnClickListener {
            // Primer za editText i ucitavanje slike u imageView
            val intent = Intent(this, InputAndImageActivity::class.java)
            startActivity(intent)
        }

        scrollBtn.setOnClickListener {
            // Primer za ScrollView
            val intent = Intent(this, ScrollActivity::class.java)
            startActivity(intent)
        }

        linearBtn.setOnClickListener {
            // Primer za weight-ove u LineaLayout-u i razliku izmedju paddinga i margina
            val intent = Intent(this, LinearActivity::class.java)
            startActivity(intent)
        }
    }
}


