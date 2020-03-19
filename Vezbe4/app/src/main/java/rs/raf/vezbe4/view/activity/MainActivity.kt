package rs.raf.vezbe4.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe4.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        messageTv.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.MESSAGE_KEY, "Hey, this is message from MainActivity!")
            // ukoliko bismo ovde pozvali finish() activity bi bio uklonjen sa activity backstack-a
            // pre nego sto bi na njega bio push-ovan SecondActivity
            // finish()
            startActivity(intent)
        }
    }

}