package com.senai.carteirinhadigital.feature.auth.domain.repository

import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}