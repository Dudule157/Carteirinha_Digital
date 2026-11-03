package com.senai.carteirinhadigital.app.di

import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.feature.auth.domain.repository.LoginRepository
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import com.senai.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaProfessorRepository
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
    val turmaProfessorRepository: TurmaProfessorRepository
    val unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository
}