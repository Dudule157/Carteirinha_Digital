package com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation.UnidadeCurricularProfessorViewModel
import kotlin.jvm.java

class UnidadeCurricularProfessorViewModelFactory(
    private val repository: UnidadeCurricularProfessorRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnidadeCurricularProfessorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UnidadeCurricularProfessorViewModel(repository) as T
        }
        throw kotlin.IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
