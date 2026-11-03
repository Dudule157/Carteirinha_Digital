package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation

import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)