package com.kingsler.riseofj2r.data.local

import Dao1
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Instruction1::class], version = 1)
abstract class Database1 : RoomDatabase() {
    abstract fun instructionDao(): Dao1
}

