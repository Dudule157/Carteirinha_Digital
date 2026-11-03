package com.senai.carteirinhadigital.feature.auth.data.remote.service

import com.senai.carteirinhadigital.feature.auth.data.remote.dto.LoginRequestDto
import com.senai.carteirinhadigital.feature.auth.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestDto): LoginResponseDto
}