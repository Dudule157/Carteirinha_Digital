package com.senai.carteirinhadigital.feature.aluno.carteirinha.presentation.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rafaelcosta.carteirinhadigital_4devm_t1.feature.carteirinha.presentation.component.QrCode
import com.senai.carteirinhadigital.R
import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.feature.aluno.carteirinha.presentation.component.PerfilAluno

@Composable
fun CarteirinhaScreen(
    usuarioLogado: UsuarioLogado,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.senai),
            contentDescription = "Fundo",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.35f),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo Senai",
                modifier = Modifier
                    .fillMaxWidth(0.72f)
            )

            PerfilAluno(
                nome = usuarioLogado.nome,
                matricula = usuarioLogado.matricula,
                curso = usuarioLogado.curso
            )

            QrCode(
                conteudo = usuarioLogado.matricula
            )
        }
    }
}