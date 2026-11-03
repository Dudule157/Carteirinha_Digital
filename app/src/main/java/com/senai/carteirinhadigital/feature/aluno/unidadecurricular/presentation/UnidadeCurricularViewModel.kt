package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UnidadeCurricularViewModel(
    private val repository : com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(_root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularUiState())
    val uiState:StateFlow<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularUiState> = _uiState.asStateFlow()
    fun carregar() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.listar()
                .onSuccess { unidades ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            unidades = unidades,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar unidades curriculares."
                        )
                    }
                }
        }
    }
}