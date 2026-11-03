package com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation

import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.model.UnidadeCurricularProfessor

data class UnidadeCurricularProfessorUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricularProfessor> = emptyList(),
    val errorMessage: String? = null
)
