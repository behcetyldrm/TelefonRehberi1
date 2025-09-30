package com.example.telefonrehberi.module

import android.content.Context
import androidx.annotation.UiContext
import androidx.room.Room
import com.example.telefonrehberi.roomdatabase.RehberDao
import com.example.telefonrehberi.roomdatabase.RehberDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : RehberDatabase {
        return Room.databaseBuilder(
            context,
            RehberDatabase::class.java,
            "rehber_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(db: RehberDatabase) : RehberDao {
        return db.rehberDao()
    }
}