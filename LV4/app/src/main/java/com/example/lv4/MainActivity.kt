package com.example.lv4

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
	private lateinit var sensorManager: SensorManager;
	private lateinit var accelerationSensor: Sensor

	private val accelerationDisplay : TextView = findViewById(R.id.accelerationDisplay)
	private val accelerationComponents : TextView = findViewById(R.id.accelerationComponents)

	private val sensorListener = object : SensorEventListener {
		override fun onSensorChanged(event: SensorEvent?) {
			val values = event?.values ?: floatArrayOf(0.0f, 0.0f, 0.0f)
			updateUi(values)
		}

		override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
			TODO("Not yet implemented")
		}
	}

	fun updateUi(sensorValues: FloatArray) {
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}