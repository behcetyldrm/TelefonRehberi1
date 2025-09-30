package com.example.telefonrehberi.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.telefonrehberi.model.RehberModel

@Database(entities = [RehberModel::class], version = 1)
abstract class RehberDatabase() : RoomDatabase(){
    abstract fun rehberDao() : RehberDao
}