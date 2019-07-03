package com.example.data.source.local

import androidx.room.*
import com.example.data.datamodels.RoomRockStar

/**
 * Created by Festus Kiambi on 7/3/19.
 */

@Dao
interface RoomRockStarDao {

    @Query("SELECT * FROM bookmarks ORDER BY `index`")
    fun getNotes(): List<RoomRockStar>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateNote(rockStar: RoomRockStar): Long

    @Delete
    fun deleteNote(rockStar: RoomRockStar)

}