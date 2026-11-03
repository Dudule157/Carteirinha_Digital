package com.senai.carteirinhadigital.feature.professor.turmas.data.remote.service

import com.senai.carteirinhadigital.feature.professor.turmas.data.remote.dto.TurmaResponseDTO
import retrofit2.http.GET

interface TurmaProfessorApi {
    @GET("professores/me/turmas")
    suspend fun listarMinhasTurmas(): List<TurmaResponseDTO>
}
