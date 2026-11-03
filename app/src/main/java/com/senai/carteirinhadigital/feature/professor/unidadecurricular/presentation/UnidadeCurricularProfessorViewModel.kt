package com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.onFailure
import kotlin.onSuccess

class UnidadeCurricularProfessorViewModel(
    private val repository: UnidadeCurricularProfessorRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UnidadeCurricularProfessorUiState())
    val uiState: StateFlow<UnidadeCurricularProfessorUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            repository.listarMinhasUnidadesCurriculares()
                .onSuccess { unidades ->
                    _uiState.update { it.copy(isLoading = false, unidades = unidades) }
                }
                .onFailure { error ->
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = error.message ?: "Erro ao carregar unidades curriculares.")
                    }
                }
        }
    }
}
