package com.example.inventory.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(tableName = "item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "price")
    public double price;
    @ColumnInfo(name = "quantity")
    public int quantity;
}