package com.kingsler.riseofj2r.ApiScreens

data class ApiParameter(
    val name: String,
    val type: String,
    val required: Boolean,
    val description: String
)

data class ApiCard(
    val name: String,
    val description: String,
    val method: String,
    val endpoint: String,
    val parameters: List<ApiParameter>,
    val authentication: String
)

fun main() {
    val weatherApi = ApiCard(
        name = "Weather API",
        description = "Provides current weather data for any location worldwide.",
        method = "GET",
        endpoint = "https://api.weather.com/v1/current",
        parameters = listOf(
            ApiParameter("location", "String", true, "City name or coordinates"),
            ApiParameter("units", "String", false, "\"metric\" or \"imperial\""),
            ApiParameter("apikey", "String", true, "Your API key")
        ),
        authentication = "API Key in query params"
    )

    printApiCard(weatherApi)
}

fun printApiCard(apiCard: ApiCard) {
    println("API Name: ${apiCard.name}")
    println("Description: ${apiCard.description}")
    println("Method: ${apiCard.method}")
    println("Endpoint: ${apiCard.endpoint}")
    println("Parameters:")
    apiCard.parameters.forEach { param ->
        println(" - ${param.name} (${param.type})${if(param.required) " [Required]" else ""}: ${param.description}")
    }
    println("Authentication: ${apiCard.authentication}")
}
