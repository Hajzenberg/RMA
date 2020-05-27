package rs.raf.vezbe12.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe12.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        applyPercentageBtn.setOnClickListener {
            val percentage = inputEt.text.toString()
            percentagePtv.text = percentage // This implicitly calls invalidate on textView
        }
    }
}
