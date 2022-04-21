package com.example.lv4

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private lateinit var sensorManager: SensorManager
	private lateinit var accelerationSensor: Sensor

	private val accelerationDisplay = findViewById<TextView>(R.id.accelerationDisplay)
	private val accelerationComponents = findViewById<TextView>(R.id.accelerationComponents)

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
		var sum: Double = 0.0;
		for (value: Float in sensorValues) {
			sum += value.toDouble() * value.toDouble()
		}
		val totalAcceleration = Math.sqrt(sum)
		accelerationDisplay.text = "Total acceleration: $totalAcceleration"
		accelerationComponents.text = "Acceleration: ${sensorValues[0]}, ${sensorValues[1]}, ${sensorValues[2]}"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}