package com.example.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datamodels.RoomRockStar

/**
 * Created by Festus Kiambi on 7/3/19.
 */

@Database(entities = [RoomRockStar::class], version = 1, exportSchema = false)
abstract class RockStarDataBase : RoomDatabase() {

    abstract fun RoomRockStarDao(): RoomRockStarDao

}