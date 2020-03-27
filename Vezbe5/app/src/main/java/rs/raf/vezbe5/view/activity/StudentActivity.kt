package rs.raf.vezbe5.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_student.*
import rs.raf.vezbe5.R
import rs.raf.vezbe5.models.Student

class StudentActivity : AppCompatActivity(R.layout.activity_student) {

    companion object {
        const val STUDENT_KEY = "studentKey"
    }

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        parseIntent()
        initListeners()
    }

    private fun parseIntent() {
        // Proveravamo da li nam je sa MainActivity-a prosledjen student
        intent?.let {
            student = it.getParcelableExtra(STUDENT_KEY)
            val message = if (student != null) {
                "Received student with name ${student?.name}"
            } else {
                "I haven't received any student :("
            }
            studentMessageTv.text = message
        }
    }

    private fun initListeners() {
        backBtn.setOnClickListener {
            val returnIntent = Intent()
            if (student != null) {
                // Ako je sa MainActivity-a prosledjen student vracamo nazad poruku i
                // oznacavamo da je operacija uspela sa RESULT_OK
                val message = "StudentActivity confirms it have received student with name ${student?.name}"
                returnIntent.putExtra(MainActivity.STUDENT_RECEIVED_MESSAGE, message)
                setResult(Activity.RESULT_OK, returnIntent)
            } else {
                // Posto student nije prodsledjen sa MainActivity-a oznacavamo da operacija
                // nije uspela
                setResult(Activity.RESULT_CANCELED)
            }
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
