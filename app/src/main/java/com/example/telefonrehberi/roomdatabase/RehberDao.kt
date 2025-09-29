package com.example.telefonrehberi.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.telefonrehberi.model.RehberModel

@Dao
interface RehberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(kisi: RehberModel)

    @Delete
    suspend fun deleteData(kisi: RehberModel)

    @Query("SELECT * FROM RehberModel")
    suspend fun getAllData() : List<RehberModel>
}