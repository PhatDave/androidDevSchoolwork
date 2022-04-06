package com.example.lv3.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lv3.R
import com.example.lv3.data.DataSource

class TaskAdapter(private val dataSource: DataSource): RecyclerView.Adapter<TaskAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskAdapter.ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}