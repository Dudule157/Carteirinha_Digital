package com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository

import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.model.UnidadeCurricularProfessor

interface UnidadeCurricularProfessorRepository {
    suspend fun listarMinhasUnidadesCurriculares(): Result<List<UnidadeCurricularProfessor>>
}
