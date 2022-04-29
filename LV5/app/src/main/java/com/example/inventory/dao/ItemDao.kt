package com.example.inventory.dao

import androidx.room.*
import com.example.inventory.entity.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(item: Item)
	@Update
	suspend fun update(item: Item)
	@Delete
	suspend fun delete(item: Item)
	@Query("SELECT * from item WHERE id = :id")
	fun getById(id: Int): Flow<Item>
	@Query("SELECT * from item ORDER BY name ASC")
	fun getAll(): Flow<List<Item>>
}
