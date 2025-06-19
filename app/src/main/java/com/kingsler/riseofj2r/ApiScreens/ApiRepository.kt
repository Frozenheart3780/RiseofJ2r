package com.kingsler.riseofj2r.data.remote

import com.kingsler.riseofj2r.data.model.ApiResponse
import com.kingsler.riseofj2r.data.model.Instruction
import retrofit2.Response
import retrofit2.http.GET

interface ApiRepository {

    @GET("dashboard") // 🔁 Replace "dashboard" with your actual endpoint
    suspend fun getDashboardData(): Response<ApiResponse>
    fun getData()
    fun deleteInstruction(instruction: Instruction)
}

