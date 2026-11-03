package com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.remote.dto

import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.model.UnidadeCurricularProfessor
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularProfessorResponseDTO(
    val id: String,
    val nome: String,
    val turmaId: String,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain() = UnidadeCurricularProfessor(
        id, nome, turmaId, turma, cargaHoraria, quantidadeAulas,
        aulasRealizadas, diasSemana, horarioInicio, horarioFim
    )
}
