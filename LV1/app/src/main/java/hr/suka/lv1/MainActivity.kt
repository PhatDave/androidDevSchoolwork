package hr.suka.lv1

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import android.R.attr.data




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity: ", "onCreate")

        val entry1 = findViewById<EditText>(R.id.entry1)
        val entry2 = findViewById<EditText>(R.id.entry2)
        val bmiSubmit = findViewById<Button>(R.id.bmiSubmit)

        val firstName = findViewById<EditText>(R.id.nameSurnameEditText)
        val firstNameReadonly = findViewById<TextView>(R.id.textView1)
        val userSubmit = findViewById<Button>(R.id.userSubmit)

        userSubmit.setOnClickListener {
            val name = firstName.text.toString()
            firstNameReadonly.text = name
        }


        bmiSubmit.setOnClickListener {
            val height = entry1.text.toString()
            val weight = entry2.text.toString()

            val intHeight = height.toFloat()
            val intWeight = weight.toFloat()

            val bmi = calculateBmi(intHeight, intWeight)
            Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()
        }
    }

    fun calculateBmi(height: Float, weight: Float): Float {
        return weight / (height * height)
    }
}
