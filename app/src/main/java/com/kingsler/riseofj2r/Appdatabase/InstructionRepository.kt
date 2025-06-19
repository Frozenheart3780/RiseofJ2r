package com.kingsler.riseofj2r.data.local

class InstructionRepository(private val dao: Dao1) {
    suspend fun getAll() = dao.getAllInstructions()
    suspend fun getByCategory(category: String) = dao.getInstructionsByCategory(category)
    suspend fun insert(instruction: Instruction1) = dao.insertInstruction(instruction)
    suspend fun delete(instruction: Instruction1) = dao.deleteInstruction(instruction)
}
