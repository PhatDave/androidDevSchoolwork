package com.example.inventory

import androidx.lifecycle.*
import com.example.inventory.dao.ItemDao
import com.example.inventory.entity.Item
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {
	val allItems: LiveData<List<Item>> = itemDao.getAll().asLiveData()

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

	fun retrieveItem(id: Int): LiveData<Item> {
		return itemDao.getById(id).asLiveData()
	}

	private fun updateItem(item: Item) {
		viewModelScope.launch {
			itemDao.update(item)
		}
	}

	fun sellItem(item: Item) {
		if (item.quantity > 0) {
			item.quantity--
			updateItem(item)
		}
	}

	fun deleteItem(item: Item) {
		viewModelScope.launch {
			itemDao.delete(item)
		}
	}

	fun isStockAvailable(item: Item): Boolean {
		return (item.quantity > 0)
	}

	private fun getUpdatedItemEntry(
		itemId: Int,
		itemName: String,
		itemPrice: String,
		itemCount: String
	): Item {
		val item = Item()
		item.id = itemId
		item.name = itemName
		item.price = itemPrice.toDouble()
		item.quantity = itemCount.toInt()
		return item
	}

	fun updateItem(
		itemId: Int,
		itemName: String,
		itemPrice: String,
		itemCount: String
	) {
		val updatedItem = getUpdatedItemEntry(itemId, itemName, itemPrice, itemCount)
		updateItem(updatedItem)
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
