package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service

import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.dto.UnidadeCurricularDto>
}