package com.kingsler.riseofj2r.repository

import com.kingsler.riseofj2r.data.local.Dao1
import com.kingsler.riseofj2r.data.local.Instruction1
import javax.inject.Inject

class InstructionRepository @Inject constructor(
    private val dao: Dao1
) {
    suspend fun getAll() = dao.getAll()
    suspend fun getByCategory(category: String) = dao.getByCategory(category)
    suspend fun insert(instruction: Instruction1) = dao.insert(instruction)
    suspend fun delete(instruction: Instruction1) = dao.delete(instruction)
}
