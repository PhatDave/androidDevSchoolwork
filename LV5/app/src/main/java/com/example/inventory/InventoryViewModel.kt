package com.example.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.inventory.dao.ItemDao
import com.example.inventory.entity.Item
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {
	private fun insertItem(item: Item) {
		viewModelScope.launch {
			itemDao.insert(item)
		}
	}

	private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String): Item {
		val item = Item()
		item.name = itemName
		item.price = itemPrice.toDouble()
		item.quantity = itemCount.toInt()
		return item
	}

	fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
		val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
		insertItem(newItem)
	}

	fun isEntryValid(itemName: String, itemPrice: String, itemCount: String): Boolean {
		if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
			return false
		}
		return true
	}

}

class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
			@Suppress("UNCHECKED_CAST")
			return InventoryViewModel(itemDao) as T
		}
		throw IllegalArgumentException("Unknown ViewModel class")
	}
}
