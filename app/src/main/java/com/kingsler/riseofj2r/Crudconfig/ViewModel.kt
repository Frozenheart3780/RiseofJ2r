package com.kingsler.riseofj2r.data.local

import com.kingsler.riseofj2r.Crudconfig.Instruction

class FakeInstructionDao : InstructionDao {

    private val instructions = mutableListOf<Instruction1>()

    // ========== CRUD Methods ==========

    override suspend fun insertInstruction(instruction: Instruction1) {
        instructions.add(instruction)
    }

    override suspend fun deleteInstruction(instruction: Instruction1) {
        instructions.removeIf { it.id == instruction.id }
    }

    override suspend fun getAllInstructions(): List<Instruction1> {
        return instructions.toList()
    }

    override suspend fun getInstructionsByCategory(category: String): List<Instruction1> {
        return instructions.filter { it.category.equals(category, ignoreCase = true) }
    }

    // ========== Optional helpers ==========

    // You can map between Instruction and Instruction1 if needed
    fun fromInstruction(instruction: Instruction): Instruction1 {
        return Instruction1(
            id = instruction.id,
            title = instruction.title,
            category = instruction.category,
            content = instruction.content
        )
    }

    fun toInstruction(instruction1: Instruction1): Instruction {
        return Instruction(
            id = instruction1.id,
            title = instruction1.title,
            category = instruction1.category,
            content = instruction1.content
        )
    }
}
