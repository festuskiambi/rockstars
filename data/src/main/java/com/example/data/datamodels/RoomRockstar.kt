package com.example.data.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created by Festus Kiambi on 7/3/19.
 */

@Entity(
    tableName = "bookmarks",
    indices = [Index("id")]
)
data class RoomRockStar(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "about")
    val about: String,

    @ColumnInfo(name = "index")
    val index: Int,

    @ColumnInfo(name = "picture")
    val picture: String
)