package com.kingsler.riseofj2r.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao1 {
    @Query("SELECT * FROM instructions")
    suspend fun getAll(): List<Instruction1>

    @Query("SELECT * FROM instructions WHERE category = :category")
    suspend fun getByCategory(category: String): List<Instruction1>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(instruction: Instruction1)

    @Delete
    suspend fun delete(instruction: Instruction1)
    fun getAllInstructions(): Any
    fun insertInstruction(instruction1: Instruction1): Any {
        TODO("Not yet implemented")
    }

    fun getInstructionsByCategory(string: String): Any {
        TODO("Not yet implemented")
    }

    fun deleteInstruction(instruction1: Instruction1): Any {
        TODO("Not yet implemented")
    }
}
