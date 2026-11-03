package com.senai.carteirinhadigital.feature.professor.turmas.presentation

import com.senai.carteirinhadigital.feature.professor.turmas.domain.model.Turma

data class TurmaProfessorUiState(
    val isLoading: Boolean = false,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)