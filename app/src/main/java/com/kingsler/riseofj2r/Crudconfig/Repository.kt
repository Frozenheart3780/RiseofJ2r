package com.kingsler.riseofj2r.Crudconfig

// InstructionRepository.kt
class InstructionRepository(private val dao: InstructionDao) {
    suspend fun create(instruction: Instruction) = dao.insert(instruction)
    suspend fun readAll() = dao.getAll()
    suspend fun readByCategory(category: String) = dao.getByCategory(category)
    suspend fun update(instruction: Instruction) = dao.update(instruction)
    suspend fun delete(instruction: Instruction) = dao.delete(instruction)
}
