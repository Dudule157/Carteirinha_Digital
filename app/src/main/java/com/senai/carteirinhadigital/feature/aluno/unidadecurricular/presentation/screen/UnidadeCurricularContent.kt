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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carteirinhadigital.feature.home.presentation.screen.UnidadeCurricularCard
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularContent(
    modifier: Modifier = Modifier,
    unidadesCurriculares: List<com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Unidades Curriculares",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        items(unidadesCurriculares) { unidadeCurricular ->
            _root_ide_package_.com.senai.carteirinhadigital.feature.home.presentation.screen.UnidadeCurricularCard(
                unidadeCurricular = unidadeCurricular
            )
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun UnidadeCurricularContentPreview() {
    _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.screen.UnidadeCurricularContent(
        unidadesCurriculares = listOf(
            _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular(
                id = "1",
                nome = "Matemática",
                professor = "João",
                nota1 = 7.8,
                nota2 = 8.5,
                media = 8.15,
                faltas = 1
            ),
            _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular(
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