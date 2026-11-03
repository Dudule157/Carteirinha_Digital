package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.repository

import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import okio.IOException
import retrofit2.HttpException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: com.senai.carteirinhadigital.feature.aluno.unidadecurricular.data.remote.service.UnidadeCurricularApi
) : com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository {

    override suspend fun listar(): Result<List<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular>> {
        return runCatching {
            api.listar().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}