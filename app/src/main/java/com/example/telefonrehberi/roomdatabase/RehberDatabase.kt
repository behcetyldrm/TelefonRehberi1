package com.example.telefonrehberi.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.telefonrehberi.model.RehberModel

@Database(entities = [RehberModel::class], version = 1)
abstract class RehberDatabase() : RoomDatabase(){
    abstract fun rehberDao() : RehberDao

    object DatabaseProvider {
        private var INSTANCE: RehberDatabase? = null

        fun getDatabase(context: Context): RehberDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RehberDatabase::class.java,
                    "rehber_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}