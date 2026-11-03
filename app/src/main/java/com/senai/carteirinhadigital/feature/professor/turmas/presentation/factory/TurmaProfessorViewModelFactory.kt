package com.senai.carteirinhadigital.feature.professor.turmas.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaProfessorRepository
import com.senai.carteirinhadigital.feature.professor.turmas.presentation.TurmaProfessorViewModel
import kotlin.jvm.java

class TurmaProfessorViewModelFactory(
    private val repository: TurmaProfessorRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmaProfessorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TurmaProfessorViewModel(repository) as T
        }
        throw kotlin.IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
