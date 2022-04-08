package com.example.lv3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lv3.R
import com.example.lv3.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val dataSet = DataSource().loadTasks()
        recyclerView.adapter = TaskAdapter(dataSet, this)

        // todo dolje text input i button i to onda ide u listu
    }
}