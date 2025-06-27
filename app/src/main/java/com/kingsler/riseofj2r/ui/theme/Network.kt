package com.kingsler.riseofj2r.network

import android.util.Base64
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object MpesaApi {
    var customerName: String = ""
    var phoneNumber: String = ""
    var amount: String = ""

    private const val CONSUMER_KEY = "YOUR_CONSUMER_KEY"
    private const val CONSUMER_SECRET = "YOUR_CONSUMER_SECRET"
    private const val BUSINESS_SHORT_CODE = "174379" // test short code
    private const val PASSKEY = "YOUR_PASSKEY"
    private const val CALLBACK_URL = "https://yourdomain.com/callback"

    private const val BASE_URL = "https://sandbox.safaricom.co.ke"
    private val client = OkHttpClient()

    suspend fun performSTKPush(): Boolean = withContext(Dispatchers.IO) {
        try {
            val token = getAccessToken() ?: return@withContext false

            val timestamp = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
            val password = Base64.encodeToString(
                "$BUSINESS_SHORT_CODE$PASSKEY$timestamp".toByteArray(),
                Base64.NO_WRAP
            )

            val bodyJson = JSONObject().apply {
                put("BusinessShortCode", BUSINESS_SHORT_CODE)
                put("Password", password)
                put("Timestamp", timestamp)
                put("TransactionType", "CustomerPayBillOnline")
                put("Amount", amount)
                put("PartyA", phoneNumber)
                put("PartyB", BUSINESS_SHORT_CODE)
                put("PhoneNumber", phoneNumber)
                put("CallBackURL", CALLBACK_URL)
                put("AccountReference", customerName)
                put("TransactionDesc", "Payment for RiseOfJ")
            }

            val request = Request.Builder()
                .url("$BASE_URL/mpesa/stkpush/v1/processrequest")
                .addHeader("Authorization", "Bearer $token")
                .post(RequestBody.create("application/json".toMediaTypeOrNull(), bodyJson.toString()))
                .build()

            val response = client.newCall(request).execute()
            val result = response.body?.string()

            Log.d("MpesaAPI", "STK Response: $result")

            return@withContext response.isSuccessful
        } catch (e: Exception) {
            e.printStackTrace()
            return@withContext false
        }
    }

    private suspend fun getAccessToken(): String? = withContext(Dispatchers.IO) {
        val creds = "$CONSUMER_KEY:$CONSUMER_SECRET"
        val basicAuth = "Basic " + Base64.encodeToString(creds.toByteArray(), Base64.NO_WRAP)

        val request = Request.Builder()
            .url("$BASE_URL/oauth/v1/generate?grant_type=client_credentials")
            .addHeader("Authorization", basicAuth)
            .build()

        try {
            val response = client.newCall(request).execute()
            val result = response.body?.string()
            val json = JSONObject(result ?: return@withContext null)
            return@withContext json.getString("access_token")
        } catch (e: Exception) {
            e.printStackTrace()
            return@withContext null
        }
    }
}
