package com.kingsler.riseofj2r.Crudconfig

// InstructionDao.kt
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface InstructionDao {

    @Insert
    suspend fun insert(instruction: Instruction)

    @Query("SELECT * FROM instructions")
    suspend fun getAll(): List<Instruction>

    @Query("SELECT * FROM instructions WHERE category = :category")
    suspend fun getByCategory(category: String): List<Instruction>

    @Update
    suspend fun update(instruction: Instruction)

    @Delete
    suspend fun delete(instruction: Instruction)
}
