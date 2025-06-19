package com.kingsler.riseofj2r.data.remote

import com.kingsler.riseofj2r.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("dashboard") // 🔁 Replace with your actual endpoint
    suspend fun getDashboardData(): Response<ApiResponse>
}
