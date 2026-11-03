package com.senai.carteirinhadigital.feature.professor.turmas.data.remote.dto

import com.senai.carteirinhadigital.feature.professor.turmas.domain.model.Turma
import kotlinx.serialization.Serializable

@Serializable
data class TurmaResponseDTO(
    val id: String,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain() = Turma(
        id = id,
        codigo = codigo,
        curso = curso,
        semestre = semestre,
        quantidadeAlunos = quantidadeAlunos,
        diasSemana = diasSemana,
        horarioInicio = horarioInicio,
        horarioFim = horarioFim
    )
}