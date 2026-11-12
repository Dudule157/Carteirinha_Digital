package com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular
import com.senai.carteirinhadigital.feature.home.presentation.screen.UnidadeCurricularCard
import com.senai.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme

@Composable
fun UnidadeCurricularContent(
    modifier: Modifier = Modifier,
    unidadesCurriculares: List<UnidadeCurricular>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "Unidades curriculares",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
        items(items = unidadesCurriculares, key = { it.id }) { unidade ->
            UnidadeCurricularCard(unidadeCurricular = unidade)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UnidadeCurricularContentPreview() {
    CarteirinhaDigitalTheme {
        UnidadeCurricularContent(
            unidadesCurriculares = listOf(
                UnidadeCurricular(
                    id = "1",
                    nome = "Matemática",
                    professor = "João",
                    nota1 = 7.8,
                    nota2 = 8.5,
                    media = 8.15,
                    faltas = 1
                ),
                UnidadeCurricular(
                    id = "2",
                    nome = "Programação",
                    professor = "Maria",
                    nota1 = 9.0,
                    nota2 = 8.5,
                    media = 8.75,
                    faltas = 0
                )
            )
        )
    }
}