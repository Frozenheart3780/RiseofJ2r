package com.kingsler.riseofj2r.data.local

import Dao1
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Instruction1::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun instructionDao(): Dao1
    abstract fun dao1(): Dao1

    companion object {
        @Volatile private var INSTANCE: Database1? = null

        fun getDatabase(context: Context): Database1 {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    Database1::class.java,
                    "racing_game_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
