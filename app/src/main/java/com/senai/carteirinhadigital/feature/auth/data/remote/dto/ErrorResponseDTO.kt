package com.senai.carteirinhadigital.feature.auth.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val message: String? = null
)