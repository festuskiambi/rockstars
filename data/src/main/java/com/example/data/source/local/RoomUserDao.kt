package com.example.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.datamodels.RoomUser

/**
 * Created by Festus Kiambi on 7/4/19.
 */
@Dao
interface RoomUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: RoomUser): Long
}