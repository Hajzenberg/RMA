package rs.raf.vezbe8.presentation.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe8.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        repositoryBtn.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
        threadingBtn.setOnClickListener {
            val intent = Intent(this, ThreadingActivity::class.java)
            startActivity(intent)
        }
        rxRepositoryBtn.setOnClickListener {

        }
    }
}
