package com.senai.carteirinhadigital.feature.professor.turmas.domain.repository

import com.senai.carteirinhadigital.feature.professor.turmas.domain.model.Turma

interface TurmaProfessorRepository {
    suspend fun listarMinhasTurmas(): Result<List<Turma>>
}
