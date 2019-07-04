package com.example.data.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created by Festus Kiambi on 7/3/19.
 */
@Entity(
    tableName = "users",
    indices = [Index("id")]
)
data class RoomUser(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "picture")
    val picture: String
)