package com.example.inventory.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventory.dao.ItemDao
import com.example.inventory.entity.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRepository : RoomDatabase() {
	companion object {
		@Volatile
		private var INSTANCE: ItemRepository? = null

		fun getInstance(context: Context): ItemRepository {
			return INSTANCE ?: synchronized(this) {
				val instance = Room.databaseBuilder(
					context.applicationContext,
					ItemRepository::class.java,
					"itemRepository"
				)
					.fallbackToDestructiveMigration()
					.build()
				INSTANCE = instance
				return instance
			}
		}
	}

	abstract fun itemDao(): ItemDao
}