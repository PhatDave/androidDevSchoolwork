package com.example.lv3.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lv3.R
import com.example.lv3.model.Task

class TaskAdapter(private val dataSource: List<Task>,
                  private val context: Context) :
	RecyclerView.Adapter<TaskAdapter.ItemViewHolder>() {
	class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
		val textView: TextView = view.findViewById(R.id.textView)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ItemViewHolder {
		val layoutItem =
			LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
		return ItemViewHolder(layoutItem)
	}

	override fun onBindViewHolder(holder: TaskAdapter.ItemViewHolder, position: Int) {
		val task = dataSource[position]
		holder.textView.text = context.resources.getString(task.stringResId)
	}

	override fun getItemCount(): Int {
		return dataSource.size
	}
}