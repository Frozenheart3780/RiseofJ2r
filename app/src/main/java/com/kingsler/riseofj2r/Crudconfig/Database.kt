package com.kingsler.riseofj2r.Crudconfig

// AppDatabase.kt
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Instruction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun instructionDao(): InstructionDao
}
