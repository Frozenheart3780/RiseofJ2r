package com.kingsler.riseofj2r.repository

import Dao1
import com.kingsler.riseofj2r.data.local.Instruction1
import javax.inject.Inject

class InstructionRepository2 @Inject constructor(
    private val dao: Dao1
) {
    suspend fun getAll(): List<Instruction1> = dao.getAllInstructions()
    suspend fun insertInstruction(instruction: Instruction1) = dao.insert(instruction)
    suspend fun deleteInstruction(instruction: Instruction1) = dao.delete(instruction)
}
