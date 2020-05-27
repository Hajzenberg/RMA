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
        applyBarHeightBtn.setOnClickListener {
            val heightDivider = inputBarEt.text.toString()
            squareView.heightDivider = Integer.parseInt(heightDivider)
            squareView.invalidate() // We manually request view redraw
        }
        applyPercentageBtn.setOnClickListener {
            val percentage = inputPercentageEt.text.toString()
            percentagePtv.text = percentage // This implicitly calls invalidate on textView
        }
    }
}
