package com.edwardcheng.littlelemon.data.local.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwardcheng.littlelemon.data.local.entity.MenuLocalEntity

@Database(entities = [MenuLocalEntity::class], version = 1)
abstract class LittleLemonRoomDatabase : RoomDatabase() {
    abstract fun getMenuDao(): MenuDao
}