package com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.remote.service

import com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.remote.dto.UnidadeCurricularProfessorResponseDTO
import retrofit2.http.GET

interface UnidadeCurricularProfessorApi {
    @GET("professores/me/unidades-curriculares")
    suspend fun listarMinhasUnidadesCurriculares(): List<UnidadeCurricularProfessorResponseDTO>
}
