package hr.suka.lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity: ", "onCreate")

        val textView = findViewById(R.id.textView1) as TextView

        textView.setOnClickListener {
            Log.d("MainActivity: ", "POG")
            textView.setText("AAAAAAAAAAA")
        }
    }
    
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity: ", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity: ", "onDestroy")
    }
}
