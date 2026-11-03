package com.senai.carteirinhadigital.app.di

import com.senai.carteirinhadigital.core.auth.SessionTokenStore
import com.senai.carteirinhadigital.core.network.NetworkClient
import com.senai.carteirinhadigital.feature.auth.data.remote.service.AuthApi
import com.senai.carteirinhadigital.feature.auth.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinhadigital.feature.auth.data.repository.FakeAuthRepository
import com.senai.carteirinhadigital.feature.auth.domain.repository.LoginRepository
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import com.senai.carteirinhadigital.feature.professor.turmas.data.remote.service.TurmaProfessorApi
import com.senai.carteirinhadigital.feature.professor.turmas.data.repository.ApiTurmaProfessorRepositoryImpl
import com.senai.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaProfessorRepository
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.remote.service.UnidadeCurricularProfessorApi
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.repository.ApiUnidadeCurricularProfessorRepositoryImpl
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository
import kotlin.jvm.java

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(BASE_URL, sessionTokenStore)

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }
    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularApi::class.java)
    }
    private val turmaProfessorApi: TurmaProfessorApi by lazy {
        networkClient.createAuthenticated(TurmaProfessorApi::class.java)
    }
    private val unidadeCurricularProfessorApi: UnidadeCurricularProfessorApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularProfessorApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) FakeAuthRepository() else ApiLoginRepositoryImpl(api = authApi)
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }
    override val turmaProfessorRepository: TurmaProfessorRepository by lazy {
        ApiTurmaProfessorRepositoryImpl(api = turmaProfessorApi)
    }
    override val unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository by lazy {
        ApiUnidadeCurricularProfessorRepositoryImpl(api = unidadeCurricularProfessorApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}