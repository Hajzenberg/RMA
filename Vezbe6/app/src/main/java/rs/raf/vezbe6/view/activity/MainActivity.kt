package rs.raf.vezbe6.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.vezbe6.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        styledBtn.setOnClickListener {
            val intent = Intent(this, StyledActivity::class.java)
            startActivity(intent)
        }
        rotationBtn.setOnClickListener {
            val intent = Intent(this, RotationActivity::class.java)
            startActivity(intent)
        }
        classicRecyclerBtn.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }
}
