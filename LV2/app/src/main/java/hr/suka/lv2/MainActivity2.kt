package hr.suka.lv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backButton = findViewById<Button>(R.id.activity2ReturnButton)
        val fragmentButton = findViewById<Button>(R.id.activity2FragmentButton)

        backButton.setOnClickListener {
            finish()
        }
    }
}