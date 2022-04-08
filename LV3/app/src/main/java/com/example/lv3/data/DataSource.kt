package com.example.lv3.data

import com.example.lv3.R
import com.example.lv3.model.Task

class DataSource {
    fun loadTasks(): List<Task> {
        return listOf<Task>(
            Task(R.string.task1),
            Task(R.string.task2),
            Task(R.string.task3)
        )
    }
}