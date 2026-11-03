package com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.repository

import com.senai.carteirinhadigital.feature.professor.unidadecurricular.data.remote.service.UnidadeCurricularProfessorApi
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.model.UnidadeCurricularProfessor
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository
import okio.IOException
import retrofit2.HttpException
import kotlin.collections.map
import kotlin.recoverCatching
import kotlin.runCatching

class ApiUnidadeCurricularProfessorRepositoryImpl(
    private val api: UnidadeCurricularProfessorApi
) : UnidadeCurricularProfessorRepository {
    override suspend fun listarMinhasUnidadesCurriculares(): Result<List<UnidadeCurricularProfessor>> = runCatching {
        api.listarMinhasUnidadesCurriculares().map { it.toDomain() }
    }.recoverCatching { error ->
        throw when (error) {
            is HttpException -> when (error.code()) {
                401 -> kotlin.IllegalStateException(
                    "Sua sessão expirou. Faça login novamente."
                )
                403 -> kotlin.IllegalStateException(
                    "A API recusou o acesso a unidades curriculares. Confira se você entrou com o perfil Professor e se o token possui a permissão necessária."
                )
                else -> kotlin.IllegalStateException(
                    "Erro ao carregar unidades curriculares (${error.code()})."
                )
            }
            is IOException -> kotlin.IllegalStateException("Não foi possível conectar à API.")
            else -> kotlin.IllegalStateException(
                error.message ?: "Erro ao carregar unidades curriculares."
            )
        }
    }
}
