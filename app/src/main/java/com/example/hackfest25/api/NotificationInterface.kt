package com.example.hackfest25.api

import android.telecom.Call
import com.example.hackfest25.model.Notification
import com.google.auth.oauth2.AccessToken
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotificationInterface {

    @POST("/v1/projects/hackfest-25-d1f0c/messages:send")
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    fun notification(
        @Body message: Notification,
        @Header("Authorization") accessToken: String = "Bearer ${com.example.hackfest25.AccessToken.getAccessToken()}"
    ): retrofit2.Call<Notification>
}