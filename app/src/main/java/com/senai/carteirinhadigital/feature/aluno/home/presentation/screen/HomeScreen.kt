package com.senai.carteirinhadigital.feature.aluno.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.core.designsystem.component.NavigationButton
import com.senai.carteirinhadigital.feature.auth.domain.model.PerfilAcesso
import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme

@Composable
fun HomeScreen(
    usuarioLogado: UsuarioLogado,
    onCarteirinhaClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp, vertical = 28.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        Text(
            text = "Olá, ${usuarioLogado.nome}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = usuarioLogado.curso,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Turma: ${usuarioLogado.turma}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Matrícula: ${usuarioLogado.matricula}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(Modifier.height(2.dp))
        NavigationButton(
            text = "Carteirinha digital",
            onClick = onCarteirinhaClick
        )
        NavigationButton(
            text = "Unidades curriculares",
            onClick = onUnidadesCurricularesClick
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeAlunoScreenPreview() {
    CarteirinhaDigitalTheme {
        HomeScreen(
            usuarioLogado = UsuarioLogado(
                id = "1",
                nome = "Eduardo Brito",
                matricula = "90000000001755046730",
                perfil = PerfilAcesso.ALUNO,
                curso = "Desenvolvimento de Sistemas",
                turma = "2DEVEST-A",
                token = "token"
            ),
            onCarteirinhaClick = {},
            onUnidadesCurricularesClick = {}
        )
    }
}
