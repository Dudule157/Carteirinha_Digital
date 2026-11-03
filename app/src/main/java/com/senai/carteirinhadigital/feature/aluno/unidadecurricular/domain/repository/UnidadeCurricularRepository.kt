package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository

import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular>>
}