package com.example.lv4

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.getChannelId
import androidx.core.app.NotificationManagerCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
	private val decimalFormat = DecimalFormat("0.00")
	private lateinit var sensorManager: SensorManager
	private lateinit var accelerationSensor: Sensor

	private var notifId: Int = 0;

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

		if (totalAcceleration > 12) {
			displayLikeNotification("NYEOWWWWWWWW", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
		}

		accelerationDisplay.text = "Total acceleration: ${decimalFormat.format(totalAcceleration)}"
		accelerationComponents.text =
			"Acceleration\n${sensorValues[0]}\n${sensorValues[1]}\n${sensorValues[2]}"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		accelerationDisplay = findViewById(R.id.accelerationDisplay)
		accelerationComponents = findViewById(R.id.accelerationComponents)

		createNotificationChannels(this)

		sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
		accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
	}

	override fun onPause() {
		super.onPause()
		sensorManager.unregisterListener(sensorListener)
	}

	override fun onResume() {
		super.onResume()
		sensorManager.registerListener(sensorListener,
			accelerationSensor,
			SensorManager.SENSOR_DELAY_FASTEST)
	}

	private fun displayLikeNotification(title: String, text: String) {
		val intent = Intent(this, MainActivity::class.java)

		val pendingIntent = PendingIntent.getActivity(
			this,
			0,
			intent,
			PendingIntent.FLAG_CANCEL_CURRENT
		)
		val notification = NotificationCompat.Builder(this, getChannelId(CHANNEL_MAIN))
			.setSmallIcon(R.mipmap.ic_launcher)
			.setContentTitle(title)
			.setContentText(text)
			.setAutoCancel(true)
			.setContentIntent(pendingIntent)
			.build()
		NotificationManagerCompat.from(this)
			.notify(notifId, notification)
		notifId++
	}
}