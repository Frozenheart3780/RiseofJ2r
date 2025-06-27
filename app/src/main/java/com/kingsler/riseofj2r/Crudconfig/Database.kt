package com.kingsler.riseofj2r.Crudconfig

// AppDatabase.kt
import Dao1
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Instruction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun instructionDao(): InstructionDao
    abstract fun dao1(): Dao1
}
