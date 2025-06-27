package com.kingsler.riseofj2r.repository

import Dao1
import com.kingsler.riseofj2r.data.local.Instruction1
import javax.inject.Inject

class InstructionRepository1 @Inject constructor(
    private val dao: Dao1
) {

    suspend fun getAll(): List<Instruction1> {
        return dao.getAllInstructions() as List<Instruction1>
    }

    suspend fun insertInstruction(instruction: Instruction1) {
        dao.insert(instruction)
    }

    suspend fun deleteInstruction(instruction: Instruction1) {
        dao.delete(instruction)
    }

    suspend fun getByCategory(category: String): List<Instruction1> {
        return dao.getByCategory(category)
    }

    // Optional aliases (if you're using these elsewhere)
    suspend fun insert(instruction: Instruction1) = dao.insert(instruction)
    suspend fun delete(instruction: Instruction1) = dao.delete(instruction)
}

