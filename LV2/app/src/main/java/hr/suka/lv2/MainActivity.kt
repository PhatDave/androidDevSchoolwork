package hr.suka.lv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val swapButton = findViewById<Button>(R.id.activity1SwapButton)

        swapButton.setOnClickListener {
            val switchActivityIntent = Intent(this, MainActivity2::class.java)
            startActivity(switchActivityIntent)
        }
    }
}