package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.*

@Entity(tableName = "character")
data class CharacterDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name="hogwarts_house")
    val hogwartsHouse:String,
    @ColumnInfo(name="image_url")
    val imageUrl:String
)