package com.example.lv4

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
	private val decimalFormat = DecimalFormat("0.00")
	private lateinit var sensorManager: SensorManager
	private lateinit var accelerationSensor: Sensor

	private lateinit var accelerationDisplay: TextView
	private lateinit var accelerationComponents: TextView

	private val sensorListener = object : SensorEventListener {
		override fun onSensorChanged(event: SensorEvent?) {
			val values = event?.values ?: floatArrayOf(0.0f, 0.0f, 0.0f)
			updateUi(values)
		}

		override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
	}

	fun updateUi(sensorValues: FloatArray) {
		var sum: Double = 0.0;
		for (value: Float in sensorValues) {
			sum += value.toDouble() * value.toDouble()
		}
		val totalAcceleration = Math.sqrt(sum)
		accelerationDisplay.text = "Total acceleration: ${decimalFormat.format(totalAcceleration)}"
		accelerationComponents.text =
			"Acceleration\n${sensorValues[0]}\n${sensorValues[1]}\n${sensorValues[2]}"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		accelerationDisplay = findViewById(R.id.accelerationDisplay)
		accelerationComponents = findViewById(R.id.accelerationComponents)

		sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
		accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
	}

	override fun onPause() {
		super.onPause()
		sensorManager.unregisterListener(sensorListener)
	}

	override fun onResume() {
		super.onResume()
		sensorManager.registerListener(sensorListener, accelerationSensor, SensorManager.SENSOR_DELAY_FASTEST)
	}
}